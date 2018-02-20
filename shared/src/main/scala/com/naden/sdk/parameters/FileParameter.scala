package com.naden.sdk.parameters

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.{File, Parameter, ParameterValidator}
import io.circe.generic.JsonCodec

@JsonCodec
case class FileParameter(title: String,
                         description: String,
                         group: Option[String],
                         default: Option[File] = None,
                         required: Boolean,
                         validators: List[ParameterValidator] = List(),
                         id: ParameterId = UUID.randomUUID()) extends Parameter with Serializable
