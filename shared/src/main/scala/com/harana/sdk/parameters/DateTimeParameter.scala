package com.harana.sdk.parameters

import java.time.Instant
import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.{DateTimeStyle, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class DateTimeParameter(name: String,
                             description: String,
                             group: Option[String],
                             default: Option[Instant] = None,
                             required: Boolean,
                             dateOptions: Seq[Instant] = Seq(),
                             dateStyle: DateTimeStyle = DateTimeStyle.Short,
                             timeStyle: DateTimeStyle = DateTimeStyle.Short,
                             validators: List[ParameterValidator] = List(),
                             id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
