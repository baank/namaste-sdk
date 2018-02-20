package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Connection, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class ConnectionParameter(title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Connection] = None,
                               required: Boolean,
                               validators: List[ParameterValidator] = List(),
                               id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
