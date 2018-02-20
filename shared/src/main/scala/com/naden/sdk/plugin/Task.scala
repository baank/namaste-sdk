package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.plugin.Task.TaskId

trait Task extends Service {}

object Task {
	type TaskId = UUID
}