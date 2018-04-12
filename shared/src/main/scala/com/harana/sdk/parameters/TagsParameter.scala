package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class TagsParameter(name: String,
                         label: String,
                         description: String,
                         group: Option[String],
                         default: Option[String] = None,
                         required: Boolean,
                         limit: Option[Int] = None,
                         allowDuplicates: Boolean = true,
                         validators: List[ParameterValidator] = List()) extends Parameter with Serializable

