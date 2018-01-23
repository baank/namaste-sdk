package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class IPAddressParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[String] = None,
                              required: Boolean,
                              options: Seq[String] = Seq(),
                              validators: List[ParameterValidator] = List()) extends Parameter

object IPAddressParameter {
	implicit val pickler: Pickler[IPAddressParameter] = generatePickler[IPAddressParameter]
}