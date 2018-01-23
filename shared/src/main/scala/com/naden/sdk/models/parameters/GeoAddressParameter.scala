package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class GeoAddressParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[String] = None,
                               required: Boolean,
                               validators: List[ParameterValidator] = List()) extends Parameter

object GeoAddressParameter {
	implicit val pickler: Pickler[GeoAddressParameter] = generatePickler[GeoAddressParameter]
}