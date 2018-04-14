package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class PasswordParameter(name: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             required: Boolean,
                             validators: List[ParameterValidator] = List()) extends Parameter with Serializable
