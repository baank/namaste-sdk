package services

import java.sql.ResultSet
import javax.inject.Inject
import javax.inject.Singleton

import play.api.libs.json.JsValue
import play.api.libs.json.Json

@Singleton
class EmbeddedObjectStoreService @Inject() (h2DatabaseService: H2DatabaseService) {
    def bootstrap() {
      h2DatabaseService.execute(
        s"""
         |CREATE TABLE IF NOT EXISTS ObjectStore (
         |  ObjectType      VARCHAR,
         |  Key             VARCHAR,
         |  Value           TEXT,
         |  InsertTimestamp TIMESTAMP
         |);
         |CREATE UNIQUE INDEX IF NOT EXISTS ObjectStoreIDX
         |  ON ObjectStore(ObjectType, Key)
         |;
         """.stripMargin)
      }

    def put(objectType: String, key: String, value: String) = {
      h2DatabaseService.execute(
        s"""
           |MERGE INTO ObjectStore
           |  KEY (ObjectType, Key)
           |  VALUES ('$objectType', '$key', '$value', CURRENT_TIMESTAMP())
           |;
         """.stripMargin)
    }

    def one[M](objectType: String, key: String, mapper:(ResultSet) => M = jsonTransformer _): Option[M] = {
      h2DatabaseService.query(s"""
           |SELECT Key, Value
           |FROM ObjectStore
           |WHERE ObjectType = '$objectType'
           |  AND Key = '$key'
           |;
         """.stripMargin, mapper).headOption
    }

    def all[M](objectType: String, page: Int = 0, pageSize:Int = 0, mapper:(ResultSet) => M = jsonTransformer _): List[M] = {
      h2DatabaseService.query(
        s"""
           |SELECT Key, Value
           |FROM ObjectStore
           |WHERE ObjectType = '$objectType'
           |ORDER BY Key
           |${if (pageSize > 0) s"LIMIT $pageSize" else ""}
           |${if (page > 0) s"OFFSET ${page * pageSize}" else ""}
           |;
         """.stripMargin, mapper)
    }

    def delete(objectType: String) = {
      h2DatabaseService.execute(s"DELETE FROM ObjectStore WHERE ObjectType = '$objectType';")
    }

    def delete(objectType: String, key: String) = {
      h2DatabaseService.execute(s"DELETE FROM ObjectStore WHERE ObjectType = '$objectType' AND Key = '$key';")
    }

    def delete() = {
      h2DatabaseService.execute("TRUNCATE TABLE ObjectStore;")
    }

    private def jsonTransformer(resultSet: ResultSet): JsValue = {
      Json.parse(
        s"""
           |{
           |  "key": "${resultSet.getString("Key")}",
           |  "value": ${resultSet.getString("Value")}
           |}
         """.stripMargin)
    }
}