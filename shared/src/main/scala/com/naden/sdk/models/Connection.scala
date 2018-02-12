package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Connection(ip4Address: Option[String],
                      ip6Address: Option[String],
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String],
                      createdBy: Option[UUID],
                      createdTime: Instant,
                      updatedBy: Option[UUID],
                      updatedTime: Instant,
                      guid: Option[UUID],
                      status: Status,
                      version: Long,
                      relationships: Map[String, UUID])
  extends Entity with Serializable {

	type EntityType = Connection
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Connection {
	def apply(ip4Address: Option[String], ip6Address: Option[String], port: Int, requireSSL: Boolean, username: Option[String], password: Option[String], createdBy: User): Connection = {
		apply(ip4Address, ip6Address, port, requireSSL, username, password, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}