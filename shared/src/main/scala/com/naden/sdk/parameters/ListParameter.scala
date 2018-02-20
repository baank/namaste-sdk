package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
  case class ListParameter[A](id: ParameterId,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[A] = None,
                              required: Boolean,
                              validators: List[ParameterValidator] = List()) extends Parameter with Serializable
