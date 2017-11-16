package com.naden.namaste.plugin.parameters

import java.awt.Color
import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class ColorParameter(key: String,
                          default: Option[Color] = None,
                          options: Seq[Color] = Seq(),
                          validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[Color](key)