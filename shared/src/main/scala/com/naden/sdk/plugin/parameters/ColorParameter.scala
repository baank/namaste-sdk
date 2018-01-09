package com.naden.sdk.plugin.parameters

import java.awt.Color

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class ColorParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          default: Option[Color] = None,
                          options: Seq[Color] = Seq(),
                          validators: List[ParameterValidator] = List())()
    extends Parameter
