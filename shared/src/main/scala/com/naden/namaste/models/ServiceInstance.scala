package com.naden.namaste.models

import com.naden.namaste.plugin.{Parameter, Service}

case class ServiceInstance[T <: Service](createdBy: User,
                                         names: String,
                                         service: T,
                                         parameterValues: Map[Parameter[_], _])
    extends Object(createdBy)
