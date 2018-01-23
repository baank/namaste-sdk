package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class TabularDataParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                required: Boolean,
                                validators: List[ParameterValidator] = List()) extends Parameter

object TabularDataParameter {
	implicit val pickler: Pickler[TabularDataParameter] = generatePickler[TabularDataParameter]
}