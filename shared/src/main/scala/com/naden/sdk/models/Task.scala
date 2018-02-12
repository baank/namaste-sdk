package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._
import enumeratum._

@JsonCodec
case class Task(title: String,
                description: String,
                taskPriority: TaskPriority,
                taskState: TaskState,
                dueTime: Instant,
                assignedUsers: List[UUID],
                createdBy: Option[UUID],
                createdTime: Instant,
                updatedBy: Option[UUID],
                updatedTime: Instant,
                guid: Option[UUID],
                status: Status,
                version: Long,
                relationships: Map[String, UUID])
    extends Entity with Serializable {

  type EntityType = Task
  def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
  def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
  def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)}

object Task {
  def apply(title: String, description: String, priority: TaskPriority, state: TaskState, dueTime: Instant, assignedUsers: List[User], createdBy: User): Task = {
    apply(title, description, priority, state, dueTime, assignedUsers.flatMap(_.guid), createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
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
