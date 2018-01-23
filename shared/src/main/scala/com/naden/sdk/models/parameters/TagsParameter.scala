package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}

case class TagsParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[String] = None,
                         required: Boolean,
                         limit: Option[Int] = None,
                         allowDuplicates: Boolean = true,
                         validators: List[ParameterValidator] = List()) extends Parameter

object TagsParameter {
	implicit val pickler: Pickler[TagsParameter] = generatePickler[TagsParameter]
}