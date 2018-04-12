package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class BooleanParameter(name: String,
                            label: String,
                            description: String,
                            group: Option[String],
                            default: Option[String] = None,
                            required: Boolean,
                            validators: List[ParameterValidator] = List()) extends Parameter with Serializable