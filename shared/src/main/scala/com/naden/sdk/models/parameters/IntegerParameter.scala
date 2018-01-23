package com.naden.sdk.models.parameters

import boopickle.Default._
import com.naden.sdk.models.{Parameter, ParameterValidator}
import com.naden.sdk.util.BoopickleCodecs._

case class IntegerParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Integer] = None,
                            required: Boolean,
                            options: Seq[Integer] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter

object IntegerParameter {
	implicit val pickler: Pickler[IntegerParameter] = generatePickler[IntegerParameter]
}