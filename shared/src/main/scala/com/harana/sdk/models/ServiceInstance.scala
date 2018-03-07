package com.harana.sdk.models

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Entity.EntityId
import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.ServiceInstance.ServiceInstanceId
import com.harana.sdk.models.User.UserId
import com.harana.sdk.plugin.Service

case class ServiceInstance[T <: Service](names: String,
                                         service: T,
                                         parameterValues: Map[ParameterId, String],
                                         createdBy: Option[UserId],
                                         createdTime: Instant,
                                         updatedBy: Option[UserId],
                                         updatedTime: Instant,
                                         id: Option[ServiceInstanceId],
                                         status: Status,
                                         version: Long,
                                         relationships: Map[String, EntityId])
    extends Entity with Serializable {

	type EntityType = ServiceInstance[T]
	def copyId(newId: UUID) = copy(id = Some(newId))
	def copyUpdate(newUpdatedBy: UserId, newUpdateTime: Instant) = copy(updatedBy = Some(newUpdatedBy), updatedTime = newUpdateTime)
    def copyUpdate(newUpdatedBy: User, newUpdateTime: Instant) = copy(updatedBy = newUpdatedBy.id, updatedTime = newUpdateTime)
}

object ServiceInstance {
	type ServiceInstanceId = UUID

	def apply[T <: Service](names: String, service: T, parameterValues: Map[ParameterId, String], createdBy: User): ServiceInstance[T] = {
		apply(names, service, parameterValues, createdBy.id, Instant.now, createdBy.id, Instant.now, None, Status.Active, 1, Map())
	}
}
