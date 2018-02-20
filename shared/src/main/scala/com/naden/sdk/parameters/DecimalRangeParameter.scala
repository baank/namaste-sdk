package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Parameter, ParameterValidator}
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
