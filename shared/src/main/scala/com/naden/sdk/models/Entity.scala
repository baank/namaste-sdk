package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

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

  val createdBy: Option[UUID]
  val createdTime: Instant
  val updatedTime: Instant
  val updatedBy: Option[UUID]
  val guid: Option[UUID]
  val status: Status
  val version: Long
  val relationships: Map[String, UUID]

  def copyGuid(guid: UUID): EntityType
  def copyUpdate(updatedBy: UUID, updateTime: Instant): EntityType
}

object Entity {
  type Indexed = com.naden.sdk.annotations.AtlasIndexed @field
  type Unique = com.naden.sdk.annotations.AtlasUnique @field
}