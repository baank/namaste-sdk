package com.naden.namaste.models

import com.naden.namaste.plugin.Service

import scala.collection.mutable

case class ServiceInstance[T <: Service](name: String,
                                         createdBy: User,
                                         service: T,
                                         parameterValues: Map[String, _])
    extends Object(createdBy)
