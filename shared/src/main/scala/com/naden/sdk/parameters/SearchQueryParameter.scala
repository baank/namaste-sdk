package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class SearchQueryParameter(title: String,
                                description: String,
                                group: Option[String],
                                required: Boolean,
                                id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
