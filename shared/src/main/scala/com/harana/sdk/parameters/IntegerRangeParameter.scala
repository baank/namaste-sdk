package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class IntegerRangeParameter(name: String,
                                 label: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[Integer] = None,
                                 required: Boolean,
                                 minimumValue: Integer = 0,
                                 maximumValue: Integer = 100,
                                 validators: List[ParameterValidator] = List()) extends Parameter with Serializable
