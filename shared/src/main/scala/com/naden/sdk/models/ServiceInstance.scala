package com.naden.sdk.models

import com.naden.sdk.plugin.Service
import boopickle.Default._

case class ServiceInstance[T <: Service](createdBy: User,
                                         names: String,
                                         service: T,
                                         parameterValues: List[(Parameter, String)])
    extends Object(createdBy)

//
//object ServiceInstance[T <: Service] {
//	implicit val pickler: Pickler[ServiceInstance[T <: Service]] = generatePickler[ServiceInstance[T <: Service]]
//}