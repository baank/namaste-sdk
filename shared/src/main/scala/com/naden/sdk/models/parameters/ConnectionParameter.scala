package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Connection, Parameter, ParameterValidator}

case class ConnectionParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Connection] = None,
                               required: Boolean,
                               validators: List[ParameterValidator] = List()) extends Parameter

object ConnectionParameter {
	implicit val pickler: Pickler[ConnectionParameter] = generatePickler[ConnectionParameter]
}