package com.naden.namaste.plugin.parameters

import java.awt.Color

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class ColorParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          default: Option[Color] = None,
                          options: Seq[Color] = Seq(),
                          validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[Color]
