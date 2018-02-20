package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Page, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class PageParameter(title: String,
                         description: String,
                         group: Option[String],
                         default: Option[Page] = None,
                         required: Boolean,
                         validators: List[ParameterValidator],
                         id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
