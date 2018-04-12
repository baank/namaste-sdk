package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class URIParameter(name: String,
                        label: String,
                        description: String,
                        group: Option[String],
                        default: Option[String] = None,
                        required: Boolean,
                        validators: List[ParameterValidator] = List()) extends Parameter with Serializable
