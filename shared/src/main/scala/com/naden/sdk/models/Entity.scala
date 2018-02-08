package com.naden.sdk.models

import java.time.Instant
import java.util.UUID
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
sealed trait Status
object Status {
  case object Active extends Status
  case object Delete extends Status
}

abstract class Entity {
  val createdBy: Option[User]
  val guid: Option[String] = None
  val createTime: Instant =  Instant.now
  val status: Status = Status.Active
  val updateTime: Instant = createTime
  val updatedBy: Option[User] = createdBy
  val version = 0L
  val icon = "Default.png"
  val relationships: Map[String, UUID] = Map()

  override def equals(o: Any): Boolean = o match {
    case that: Entity => that.guid.equals(this.guid)
    case _            => false
  }

  override final def hashCode(): Int = guid.hashCode
}