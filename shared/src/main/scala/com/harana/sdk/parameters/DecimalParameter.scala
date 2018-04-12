package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class DecimalParameter(name: String,
                            label: String,
                            description: String,
                            group: Option[String],
                            default: Option[BigDecimal] = None,
                            required: Boolean,
                            options: Seq[BigDecimal] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable

