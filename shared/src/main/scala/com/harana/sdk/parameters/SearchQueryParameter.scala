package com.harana.sdk.parameters

import java.util.UUID
import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.{Parameter, ParameterValidator, SearchQuery}
import io.circe.generic.JsonCodec

@JsonCodec
case class SearchQueryParameter(name: String,
                                description: String,
                                group: Option[String],
                                default: Option[SearchQuery] = None,
                                required: Boolean,
                                validators: List[ParameterValidator] = List(),
                                id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
