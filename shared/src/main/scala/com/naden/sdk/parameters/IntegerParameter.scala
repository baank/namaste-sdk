package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class IntegerParameter(title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Integer] = None,
                            required: Boolean,
                            options: Seq[Integer] = Seq(),
                            validators: List[ParameterValidator] = List(),
                            id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
