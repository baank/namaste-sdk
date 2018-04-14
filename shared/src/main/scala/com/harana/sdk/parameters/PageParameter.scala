package com.harana.sdk.parameters

import com.harana.sdk.models.{Page, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class PageParameter(name: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[Page] = None,
                         required: Boolean,
                         validators: List[ParameterValidator] = List()) extends Parameter with Serializable
