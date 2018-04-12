package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class IntegerParameter(name: String,
                            label: String,
                            description: String,
                            group: Option[String],
                            default: Option[Integer] = None,
                            required: Boolean,
                            options: Seq[Integer] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable
