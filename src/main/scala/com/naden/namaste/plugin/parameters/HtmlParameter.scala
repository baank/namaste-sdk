package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class HtmlParameter(key: String,
                         default: Option[String] = None,
                         validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[String](key)