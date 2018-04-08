package com.harana.sdk.parameters

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.{Color, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class ColorParameter(name: String,
                          description: String,
                          group: Option[String],
                          default: Option[Color] = None,
                          required: Boolean,
                          options: Seq[Color] = Seq(),
                          validators: List[ParameterValidator] = List(),
                          id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
