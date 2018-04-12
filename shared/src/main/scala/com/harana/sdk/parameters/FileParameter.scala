package com.harana.sdk.parameters

import com.harana.sdk.models.{File, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class FileParameter(name: String,
                         label: String,
                         description: String,
                         group: Option[String],
                         default: Option[File] = None,
                         required: Boolean,
                         validators: List[ParameterValidator] = List()) extends Parameter with Serializable
