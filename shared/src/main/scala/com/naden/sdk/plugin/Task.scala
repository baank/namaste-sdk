package com.naden.sdk.plugin

import java.util.UUID

trait Task extends Service {}

object Task {
	type TaskId = UUID
}