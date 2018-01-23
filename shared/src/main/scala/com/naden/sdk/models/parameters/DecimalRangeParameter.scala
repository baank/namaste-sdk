package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class DecimalRangeParameter(key: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[BigDecimal] = None,
                                 required: Boolean,
                                 minimumValue: BigDecimal = 0.0,
                                 maximumValue: BigDecimal = 100.0,
                                 validators: List[ParameterValidator] = List()) extends Parameter

object DecimalRangeParameter {
	implicit val pickler: Pickler[DecimalRangeParameter] = generatePickler[DecimalRangeParameter]
}