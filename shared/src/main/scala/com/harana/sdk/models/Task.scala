package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Task.TaskId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._
import enumeratum._

@JsonCodec
case class Task(title: String,
                description: String,
                taskPriority: TaskPriority,
                taskState: TaskState,
                dueTime: Instant,
                assignedUsers: List[UserId],
                createdBy: Option[UserId],
                createdTime: Instant,
                updatedBy: Option[UserId],
                updatedTime: Instant,
                id: Option[TaskId],
                status: Status,
                relationships: Map[String, EntityId])
    extends Entity with Serializable {

  type EntityType = Task
  def copyId(newId: UUID) = copy(id = Some(newId))
  def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
  def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)}

object Task {
  type TaskId = UUID

  def apply(title: String, description: String, priority: TaskPriority, state: TaskState, dueTime: Instant, assignedUsers: List[User], createdBy: User): Task = {
    apply(title, description, priority, state, dueTime, assignedUsers.flatMap(_.id), createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, Map())
  }
}

sealed trait TaskPriority extends EnumEntry
case object TaskPriority extends Enum[TaskPriority] with CirceEnum[TaskPriority] {
  case object Highest extends TaskPriority
  case object High extends TaskPriority
  case object Normal extends TaskPriority
  case object Low extends TaskPriority
  case object Lowest extends TaskPriority
  val values = findValues
}

sealed trait TaskState extends EnumEntry
case object TaskState extends Enum[TaskState] with CirceEnum[TaskState] {
  case object Open extends TaskState
  case object OnHold extends TaskState
  case object Resolved extends TaskState
  case object Duplicate extends TaskState
  case object Invalid extends TaskState
  case object WontDo extends TaskState
  case object Closed extends TaskState
  val values = findValues
}
