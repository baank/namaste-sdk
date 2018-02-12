package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.plugin.Service

case class ServiceInstance[T <: Service](names: String,
                                         service: T,
                                         parameterValues: List[(Parameter, String)],
                                         createdBy: Option[UUID],
                                         createdTime: Instant,
                                         updatedBy: Option[UUID],
                                         updatedTime: Instant,
                                         guid: Option[UUID],
                                         status: Status,
                                         version: Long,
                                         relationships: Map[String, UUID])
    extends Entity with Serializable {

	type EntityType = ServiceInstance[T]
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UUID, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object ServiceInstance {
	def apply[T <: Service](names: String, service: T, parameterValues: List[(Parameter, String)], createdBy: UUID): ServiceInstance[T] = {
		apply(names, service, parameterValues, Some(createdBy), Instant.now, Some(createdBy), Instant.now, None, Status.Active, 1, Map())
	}

	def apply[T <: Service](names: String, service: T, parameterValues: List[(Parameter, String)], createdBy: User): ServiceInstance[T] = {
		apply(names, service, parameterValues, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
