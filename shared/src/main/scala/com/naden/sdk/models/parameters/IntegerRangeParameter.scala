package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class IntegerRangeParameter(key: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[Integer] = None,
                                 required: Boolean,
                                 minimumValue: Integer = 0,
                                 maximumValue: Integer = 100,
                                 validators: List[ParameterValidator] = List()) extends Parameter

object IntegerRangeParameter {
	implicit val pickler: Pickler[IntegerRangeParameter] = generatePickler[IntegerRangeParameter]
}