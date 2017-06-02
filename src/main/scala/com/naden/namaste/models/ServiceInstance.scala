package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.Service

case class ServiceInstance[T <: Service](names: Map[Locale, String],
                                         createdBy: User,
                                         service: T,
                                         parameterValues: Map[Parameter[_], _])
    extends Object(createdBy)
