package com.naden.sdk.models

import com.naden.sdk.plugin.Service

case class ServiceInstance[T <: Service](createdBy: Option[User],
                                         names: String,
                                         service: T,
                                         parameterValues: List[(Parameter, String)])
    extends Entity
