package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class GeoLocationParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                default: Option[String] = None,
                                required: Boolean,
                                validators: List[ParameterValidator] = List()) extends Parameter

object GeoLocationParameter {
	implicit val pickler: Pickler[GeoLocationParameter] = generatePickler[GeoLocationParameter]
}