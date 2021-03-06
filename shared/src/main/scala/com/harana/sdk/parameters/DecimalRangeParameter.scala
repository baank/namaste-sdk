package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class DecimalRangeParameter(name: String,
                                 title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[BigDecimal] = None,
                                 required: Boolean,
                                 minimumValue: BigDecimal = 0.0,
                                 maximumValue: BigDecimal = 100.0,
                                 validators: List[ParameterValidator] = List()) extends Parameter with Serializable
