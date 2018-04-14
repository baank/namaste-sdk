package com.harana.sdk.parameters

import java.time.Instant
import com.harana.sdk.models.{DateTimeStyle, Parameter}
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class DateTimeParameter(name: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[Instant] = None,
                             required: Boolean,
                             dateOptions: Seq[Instant] = Seq(),
                             dateStyle: DateTimeStyle = DateTimeStyle.Short,
                             timeStyle: DateTimeStyle = DateTimeStyle.Short) extends Parameter with Serializable
