package com.naden.sdk.models

import org.threeten.bp.LocalDateTime
import java.util.UUID

import io.circe.generic.JsonCodec

@JsonCodec
sealed trait Status
object Status {
  case object Active extends Status
  case object Delete extends Status
}

abstract class Entity {

  val createdBy: User

  val guid: UUID = UUID.randomUUID()
  val createTime: LocalDateTime = LocalDateTime.now
  val status: Status = Status.Active
  val updateTime: LocalDateTime = createTime
  val updatedBy: User = createdBy
  val version = 0L
  val icon = "Default.png"
  val relationships: Map[String, UUID] = Map()

  override def equals(o: Any): Boolean = o match {
    case that: Entity => that.guid.equals(this.guid)
    case _            => false
  }

  override final def hashCode(): Int = guid.hashCode
}