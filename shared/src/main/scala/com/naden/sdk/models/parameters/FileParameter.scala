package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{File, Parameter, ParameterValidator}

case class FileParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[File] = None,
                         required: Boolean,
                         validators: List[ParameterValidator] = List()) extends Parameter

object FileParameter {
	implicit val pickler: Pickler[FileParameter] = generatePickler[FileParameter]
}