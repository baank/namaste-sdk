package com.naden.sdk.models

import java.time.Instant
import java.util.UUID

import com.naden.sdk.models.Entity.EntityId
import com.naden.sdk.models.ServiceInstance.ServiceInstanceId
import com.naden.sdk.models.User.UserId
import com.naden.sdk.plugin.Service

case class ServiceInstance[T <: Service](names: String,
                                         service: T,
                                         parameterValues: Map[Parameter, String],
                                         createdBy: Option[UserId],
                                         createdTime: Instant,
                                         updatedBy: Option[UserId],
                                         updatedTime: Instant,
                                         guid: Option[ServiceInstanceId],
                                         status: Status,
                                         version: Long,
                                         relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = ServiceInstance[T]
	def copyGuid(newGuid: UUID) = copy(guid = Some(newGuid))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.guid, updatedTime = newUpdateTime)
}

object ServiceInstance {
	type ServiceInstanceId = UUID

	def apply[T <: Service](names: String, service: T, parameterValues: Map[Parameter, String], createdBy: User): ServiceInstance[T] = {
		apply(names, service, parameterValues, createdBy.guid, Instant.now, createdBy.guid, Instant.now, None, Status.Active, 1, Map())
	}
}
