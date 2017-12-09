package com.naden.namaste.models

import java.time.LocalDateTime

import com.naden.namaste.models.TaskPriority.TaskPriority
import com.naden.namaste.models.TaskState.TaskState

case class Task(createdBy: User,
                title: String,
                description: String,
                priority: TaskPriority,
                state: TaskState,
                dueTime: LocalDateTime,
                assignedUsers: List[User])
    extends Object(createdBy)

object TaskPriority extends Enumeration {
  type TaskPriority = Value
  val HIGHEST = Value("Highest")
  val HIGH = Value("High")
  val NORMAL = Value("Normal")
  val LOW = Value("Low")
  val LOWEST = Value("Lowest")
}

object TaskState extends Enumeration {
  type TaskState = Value
  val OPEN = Value("Open")
  val ON_HOLD = Value("On Hold")
  val RESOLVED = Value("Resolved")
  val DUPLICATE = Value("Duplicate")
  val INVALID = Value("Invalid")
  val WONT_DO = Value("Won't Do")
  val CLOSED = Value("Closed")
}
