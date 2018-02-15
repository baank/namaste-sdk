package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Connection.ConnectionId
import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.User.UserId
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Connection(ip4Address: Option[String],
                      ip6Address: Option[String],
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String],
                      createdBy: Option[UserId],
                      createdTime: Instant,
                      updatedBy: Option[UserId],
                      updatedTime: Instant,
                      guid: Option[ConnectionId],
                      status: Status,
                      version: Long,
                      relationships: Map[String, EntityId])
  extends Entity with Serializable {

	type EntityType = Connection
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object Connection {
	type ConnectionId = UUID

	def apply(ip4Address: Option[String], ip6Address: Option[String], port: Int, requireSSL: Boolean, username: Option[String], password: Option[String], createdBy: User): Connection = {
		apply(ip4Address, ip6Address, port, requireSSL, username, password, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}