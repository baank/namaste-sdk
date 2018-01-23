package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class StringParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           idealLength: Option[(Int, Int)] = None,
                           maxLength: Option[Int] = None,
                           inputFormat: Option[String] = None,
                           options: List[String] = List(),
                           validators: List[ParameterValidator] = List()) extends Parameter

object StringParameter {
	implicit val pickler: Pickler[StringParameter] = generatePickler[StringParameter]
}