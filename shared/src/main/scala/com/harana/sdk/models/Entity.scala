package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._
import enumeratum._

import scala.annotation.meta.field

sealed trait Status extends EnumEntry
case object Status extends Enum[Status] with CirceEnum[Status] {
  case object Active extends Status
  case object Delete extends Status
  val values = findValues
}

trait Entity {
  type EntityType <: Entity

  val createdBy: Option[UserId]
  val createdTime: Instant
  val updatedTime: Instant
  val updatedBy: Option[UserId]
  val id: Option[EntityId]
  val status: Status
  val relationships: Map[String, EntityId]

  def copyId(id: UUID): EntityType
  def copyUpdate(updatedBy: UUID, updateTime: Instant): EntityType
  def copyUpdate(updatedBy: User, updateTime: Instant): EntityType
}

object Entity {
  type EntityId = UUID
  type Indexed = com.harana.sdk.annotations.AtlasIndexed @field
  type Unique = com.harana.sdk.annotations.AtlasUnique @field
	type Excluded = com.harana.sdk.annotations.AtlasExcluded @field
}