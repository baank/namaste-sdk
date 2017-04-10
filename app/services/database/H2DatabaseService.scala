package services

import java.sql.ResultSet
import javax.inject.{Inject, Singleton}

import play.api.Logger
import play.api.db.Database

import scala.collection.mutable.ListBuffer

@Singleton
class H2DatabaseService @Inject() (db: Database) {

    def query[M](q:String, mapper:(ResultSet) => M): List[M] = {
      Logger.info(s"Executing SQL (and reading results): $q")
      db.withConnection { c =>
        val resultSet = c.createStatement().executeQuery(q)
        val mappedResultBuffer: ListBuffer[M] = ListBuffer()
        while (resultSet.next()) {
          mappedResultBuffer.append(mapper(resultSet))
        }
        resultSet.close()
        mappedResultBuffer.toList
      }
    }

    def execute(q: String) = {
      Logger.info(s"Executing SQL: $q")
      db.withConnection { c =>
        c.createStatement().execute(q)
      }
    }
}
