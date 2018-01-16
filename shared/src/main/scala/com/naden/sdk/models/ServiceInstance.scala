package com.naden.sdk.models

import com.naden.sdk.plugin.Service

case class ServiceInstance[T <: Service](createdBy: User,
                                         names: String,
                                         service: T,
                                         parameterValues: List[(Parameter, String)])
    extends Object(createdBy)
