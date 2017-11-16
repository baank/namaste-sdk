package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class NumberParameter[A](key: String,
                              default: Option[A] = None,
                              options: Seq[A] = Seq(),
                              validators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[A], locale: Locale)
  extends LocalizedParameter[A](key)