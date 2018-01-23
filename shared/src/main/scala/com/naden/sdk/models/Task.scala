package com.naden.sdk.models

import org.threeten.bp.LocalDateTime
import boopickle.Default._

case class Task(createdBy: User,
                title: String,
                description: String,
                priority: TaskPriority,
                state: TaskState,
                dueTime: LocalDateTime,
                assignedUsers: List[User])
    extends Object(createdBy)

sealed trait TaskPriority
object TaskPriority {
  case object Highest extends TaskPriority
  case object High extends TaskPriority
  case object Normal extends TaskPriority
  case object Low extends TaskPriority
  case object Lowest extends TaskPriority
}

sealed trait TaskState
object TaskState {
  case object Open extends TaskState
  case object OnHold extends TaskState
  case object Resolved extends TaskState
  case object Duplicate extends TaskState
  case object Invalid extends TaskState
  case object WontDo extends TaskState
  case object Closed extends TaskState
}


object Task {
	implicit val pickler: Pickler[Task] = generatePickler[Task]
}