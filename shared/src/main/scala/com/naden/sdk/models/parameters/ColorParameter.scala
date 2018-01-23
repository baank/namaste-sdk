package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Color, Parameter, ParameterValidator}

case class ColorParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Color] = None,
                            required: Boolean,
                            options: Seq[Color] = Seq(),
                            validators: List[ParameterValidator] = List()) extends Parameter

object ColorParameter {
	implicit val pickler: Pickler[ColorParameter] = generatePickler[ColorParameter]
}