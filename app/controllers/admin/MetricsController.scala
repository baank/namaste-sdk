package controllers.admin

import java.io.{ByteArrayOutputStream, PrintStream}
import javax.inject.{Inject, Singleton}

import com.codahale.metrics.ConsoleReporter
import com.codahale.metrics.health.HealthCheck
import play.api.Logger
import play.api.mvc.{AbstractController, ControllerComponents}
import services.MetricsService

import scala.collection.JavaConverters._


@Singleton
class MetricsController @Inject() (metricsService: MetricsService, components: ControllerComponents) extends AbstractController(components){

  def metrics = Action {
    def metricsAsString() = {
      val baos = new ByteArrayOutputStream()
      val ps = new PrintStream(baos)
      ConsoleReporter.forRegistry(metricsService.metricRegistry).outputTo(ps).build().report()
      ps.flush()
      ps.close()
      new String(baos.toByteArray)
    }
    Ok(metricsAsString())
  }

  def healthChecks() = Action {
    val results = metricsService.healthCheckRegistry.runHealthChecks().asScala
    val response = ""

    results.foreach { case (key: String, value: HealthCheck.Result) =>
      if (value.isHealthy) {
        response.concat(key + ": " + "OK")
      }else{
        response.concat(key + ": ERROR: " + value.getMessage)
        Logger.error("Failed health check for : " + key, value.getError)
      }
    }
    if (response.contains("ERROR"))
      InternalServerError(response)
    else
      Ok(response)
  }
}