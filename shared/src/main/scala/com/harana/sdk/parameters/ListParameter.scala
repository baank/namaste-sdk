package com.harana.sdk.parameters

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.{Parameter, ParameterValidator, ParameterValue}
import io.circe.generic.JsonCodec

@JsonCodec
case class ListParameter(name: String,
                         description: String,
                         group: Option[String],
                         default: List[ParameterValue] = List(),
                         required: Boolean,
                         validators: List[ParameterValidator] = List(),
                         id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable