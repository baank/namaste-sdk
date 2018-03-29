package com.harana.sdk.plugin

import java.util.UUID

trait HealthCheck extends Service {}

object HealthCheck {
	type HealthCheckId = UUID
}
