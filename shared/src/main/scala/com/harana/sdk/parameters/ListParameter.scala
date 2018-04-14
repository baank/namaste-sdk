package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator, ParameterValue}
import io.circe.generic.JsonCodec

@JsonCodec
case class ListParameter(name: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: List[ParameterValue] = List(),
                         required: Boolean,
                         validators: List[ParameterValidator] = List()) extends Parameter with Serializable