package com.naden.sdk.models

import com.naden.sdk.plugin.{Parameter, Service}

case class ServiceInstance[T <: Service](createdBy: User,
                                         names: String,
                                         service: T,
                                         parameterValues: Map[Parameter[_], _])
    extends Object(createdBy)
