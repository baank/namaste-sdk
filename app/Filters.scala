import javax.inject._

import play.api._
import play.api.http.{DefaultHttpFilters}
import play.filters.csrf.CSRFFilter
import play.filters.headers.SecurityHeadersFilter
import play.filters.hosts.AllowedHostsFilter

@Singleton
class Filters @Inject() (env: Environment,
                         csrfFilter: CSRFFilter,
                         allowedHostsFilter:
                         AllowedHostsFilter,
                         securityHeadersFilter: SecurityHeadersFilter) extends DefaultHttpFilters(
  csrfFilter,
  allowedHostsFilter,
  securityHeadersFilter
)