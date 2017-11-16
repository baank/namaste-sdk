package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class URLParameter[URL](key: String,
                           default: Option[URL] = None,
                           validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[URL](key)