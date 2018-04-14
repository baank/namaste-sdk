package com.harana.sdk.parameters

import com.harana.sdk.models.User.UserId
import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class UserParameter(name: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[UserId] = None,
                         required: Boolean,
                         validators: List[ParameterValidator] = List()) extends Parameter with Serializable

