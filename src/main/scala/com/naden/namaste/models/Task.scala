package com.naden.namaste.models

import java.time.LocalDateTime

import com.naden.namaste.models.Priority.Priority
import com.naden.namaste.models.Status.Status

case class Task(title: String,
                createdBy: User,
                description: String,
                priority: Priority,
                status: Status,
                dueTime: LocalDateTime,
                assignedUsers: List[User],
                )
  extends Object(createdBy)

object Priority extends Enumeration {
  type Priority = Value
  val HIGHEST = Value("Highest")
  val HIGH = Value("High")
  val NORMAL = Value("Normal")
  val LOW = Value("Low")
  val LOWEST = Value("Lowest")
}

object Status extends Enumeration {
  type Status = Value
  val OPEN = Value("Open")
  val ON_HOLD = Value("On Hold")
  val RESOLVED = Value("Resolved")
  val DUPLICATE = Value("Duplicate")
  val INVALID = Value("Invalid")
  val WONT_DO = Value("Won't Do")
  val CLOSED = Value("Closed")
}