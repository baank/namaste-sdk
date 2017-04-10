package services

import javax.inject.{Inject, Singleton}

import com.codahale.metrics._
import com.codahale.metrics.health.HealthCheck.Result
import com.codahale.metrics.health._
import play.api.libs.ws.{WSClient, WSResponse}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

@Singleton
class MetricsService @Inject() (wsClient: WSClient) {

    val metricRegistry = new MetricRegistry()
    val healthCheckRegistry = new HealthCheckRegistry()

    def counter(name: String): Counter = {
      metricRegistry.counter(name)
    }

    def histogram(name: String): Histogram = {
      metricRegistry.histogram(name)
    }

    def meter(name: String): Meter = {
      metricRegistry.meter(name)
    }

    def timer(name: String): Timer = {
      metricRegistry.timer(name)
    }

    def registerHealthCheck(name: String, healthCheck: com.codahale.metrics.health.HealthCheck) = {
      healthCheckRegistry.register(name, healthCheck)
    }

    def registerUrlHealthCheck(url: String, httpMethod: String, timeoutInMs: Option[Int]) = {
      val healthCheck = new HealthCheck {
        override def check(): Result = {
          val request = wsClient.url(url)
          var response: Future[WSResponse] = null

          if (httpMethod.equalsIgnoreCase("GET")) response = request.get()
          if (httpMethod.equalsIgnoreCase("POST")) response = request.post("")

          val healthResponse = response.map(
            r =>
              r.status match {
                case 200 => Result.healthy()
                case _ => Result.unhealthy("Failed to check url: " + url + " as it had status: " + r.status)
              }
          ).recover{
            case _ =>
              Result.unhealthy("Failed to check url: " + url + " as exception was thrown")
          }

          Await.result(healthResponse, timeoutInMs.get milliseconds)
        }
      }
      registerHealthCheck("URL Check: " + url, healthCheck)
    }

    def registerIPPortHealthCheck(ipAddress: String, port: Int) = {
      val healthCheck = new HealthCheck {
        override def check(): Result = {
          try {
            val socket = new java.net.Socket("127.0.0.1", port)
            socket.close()
            Result.healthy()
          } catch {
            case _: Throwable => Result.unhealthy("Failed to check IP/Port: " + ipAddress + ":" + port)
          }
        }
      }
      registerHealthCheck("IP/Port Check: " + ipAddress + ":" + port, healthCheck)
    }
}