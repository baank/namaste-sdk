package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class StringParameter(name: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           required: Boolean,
                           idealLength: Option[(Int, Int)] = None,
                           maxLength: Option[Int] = None,
                           inputFormat: Option[String] = None,
                           options: List[String] = List(),
                           validators: List[ParameterValidator] = List()) extends Parameter with Serializable
