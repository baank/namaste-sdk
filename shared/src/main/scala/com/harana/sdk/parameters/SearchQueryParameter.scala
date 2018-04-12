package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator, SearchQuery}
import io.circe.generic.JsonCodec

@JsonCodec
case class SearchQueryParameter(name: String,
                                label: String,
                                description: String,
                                group: Option[String],
                                default: Option[SearchQuery] = None,
                                required: Boolean,
                                validators: List[ParameterValidator] = List()) extends Parameter with Serializable
