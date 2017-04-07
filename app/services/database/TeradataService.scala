package services

import javax.inject.{Inject, Singleton}

import play.api._
import play.api.db.Database
import play.api.libs.json.{JsNull, JsValue, Json}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class TeradataService @Inject() (db: Database) {

    def databaseName(): String  = {
      return ""
    }

    def repositoryDatabaseName(): String = {
      return ""
    }

    def executeJsonQuery(sql: String): Future[JsValue] = {
      executeJsonQuery(sql, false)
    }

    def executeJsonQuery(sql: String, isBlob: Boolean): Future[JsValue] = {
      executeQuery(sql, isBlob).map {
        case value: String =>
          if (value.isEmpty) {
            JsNull
          } else {
            Json.parse(value)
          }
      }
    }

    def executeQuery(sql: String): Future[String] = {
      executeQuery(sql, false)
    }

    def executeQuery(sql: String, isBlob: Boolean): Future[String] = {
      val future: Future[String] = Future {
        db.withConnection { implicit c =>

          Logger.info("Executing Teradata SQL: " + sql)
          val ps = c.prepareStatement(sql)

          var exeRes = ps.execute()
          var updates = ps.getUpdateCount
          var rs = ""

          while (exeRes || (updates != -1)) {
            if (exeRes) {
              val resSet = ps.getResultSet()
              if (resSet.next()) {
                if (isBlob) {
                  rs = scala.io.Source.fromInputStream(resSet.getClob(1).getAsciiStream).mkString
                } else {
                  rs = resSet.getString(1)
                }
              }
            }
            exeRes = ps.getMoreResults()
            updates = ps.getUpdateCount()
          }
          rs
        }
      }
      future
    }

    def defaultUrl(ipAddress: String, port: Int) = {
      "jdbc:teradata://" + ipAddress + "/TMODE=TERADATA,CHARSET=ASCII,TCP=NODELAY+KEEPALIVE"
    }
}
