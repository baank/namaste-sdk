package com.harana.sdk.parameters

import com.harana.sdk.models.{Parameter, ParameterValidator}
import io.circe.generic.JsonCodec
import squants.Money
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class MoneyParameter(name: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          default: Option[Money] = None,
                          required: Boolean,
                          options: Seq[Money] = Seq(),
                          validators: List[ParameterValidator] = List()) extends Parameter with Serializable

