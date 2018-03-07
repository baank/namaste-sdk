package com.harana.sdk.parameters

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class DecimalRangeParameter(title: String,
                                 description: String,
                                 group: Option[String],
                                 default: Option[BigDecimal] = None,
                                 required: Boolean,
                                 minimumValue: BigDecimal = 0.0,
                                 maximumValue: BigDecimal = 100.0,
                                 validators: List[ParameterValidator] = List(),
                                 id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
