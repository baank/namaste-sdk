package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._
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
  val version: Long
  val relationships: Map[String, EntityId]

  //def displayName: String
  //def displayDescription: String
  def copyId(id: UUID): EntityType
  def copyUpdate(updatedBy: UUID, updateTime: Instant): EntityType
  def copyUpdate(updatedBy: User, updateTime: Instant): EntityType
}

object Entity {
  type EntityId = UUID
  type Indexed = com.naden.sdk.annotations.AtlasIndexed @field
  type Unique = com.naden.sdk.annotations.AtlasUnique @field
}