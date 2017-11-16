package com.naden.namaste.plugin.parameters

import java.io.File
import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class VideoParameter(key: String,
                          validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[File](key)