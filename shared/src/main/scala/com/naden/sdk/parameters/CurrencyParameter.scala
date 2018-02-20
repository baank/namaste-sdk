package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec
import squants.Money
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class CurrencyParameter(title: String,
                             description: String,
                             group: Option[String],
                             default: Option[Money] = None,
                             required: Boolean,
                             options: Seq[Money] = Seq(),
                             validators: List[ParameterValidator] = List(),
                             id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable

