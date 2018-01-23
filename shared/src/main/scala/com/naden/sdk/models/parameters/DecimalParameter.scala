package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class DecimalParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[BigDecimal] = None,
                            required: Boolean,
                            options: Seq[BigDecimal] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter

object DecimalParameter {
	implicit val pickler: Pickler[DecimalParameter] = generatePickler[DecimalParameter]
}