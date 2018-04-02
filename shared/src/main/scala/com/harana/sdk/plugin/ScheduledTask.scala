package com.harana.sdk.plugin

import java.util.UUID

trait ScheduledTask extends Service {}

object ScheduledTask {
	type ScheduledTaskId = UUID
}