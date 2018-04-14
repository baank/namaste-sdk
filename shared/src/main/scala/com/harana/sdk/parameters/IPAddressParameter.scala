package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class IPAddressParameter(name: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[String] = None,
                              required: Boolean,
                              options: Seq[String] = Seq(),
                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable
