package com.harana.sdk.plugin

import java.util.UUID

trait Task extends Service {}

object Task {
	type TaskId = UUID
}