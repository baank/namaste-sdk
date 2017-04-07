package filters

import javax.inject.{Inject, Singleton}

import akka.stream.Materializer
import play.api.mvc._
import services.MetricsService

import scala.concurrent.{ExecutionContext, Future}
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class MetricsCountingFilter @Inject() (metricsService: MetricsService, implicit override val mat: Materializer, exec: ExecutionContext) extends Filter {

  def apply(nextFilter: (RequestHeader) => Future[Result]) (requestHeader: RequestHeader): Future[Result] = {
    nextFilter(requestHeader).map { result =>
      val pathList = requestHeader.path.split("/")
      val metricName = if (pathList.length > 1) pathList(1) else "home"
      metricsService.metricRegistry.meter(metricName).mark()
      result
    }
  }
}