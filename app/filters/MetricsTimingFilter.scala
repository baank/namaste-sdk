package filters

import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

import scala.concurrent.ExecutionContext.Implicits.global

import akka.stream.Materializer
import play.api.mvc._
import services.MetricsService

import scala.concurrent.{ExecutionContext, Future}

@Singleton
class MetricsTimingFilter @Inject() (metricsService: MetricsService, implicit override val mat: Materializer, exec: ExecutionContext) extends Filter {

  def apply(nextFilter: (RequestHeader) => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {
    val startTime = System.currentTimeMillis
    nextFilter(requestHeader).map { result =>
      val pathList = requestHeader.path.split("/")
      val metricName = if (pathList.length > 1) pathList(1) else "home"
      metricsService.metricRegistry.timer(metricName).update(System.currentTimeMillis - startTime, TimeUnit.MILLISECONDS)
      result
    }
  }
}