package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class GeoLocationParameter(name: String,
                                label: String,
                                description: String,
                                group: Option[String],
                                default: Option[(Double, Double)] = None,
                                required: Boolean,
                                validators: List[ParameterValidator] = List()) extends Parameter with Serializable
