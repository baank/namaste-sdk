package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class ListParameter[A](key: String,
                            default: Option[A] = None,
                            validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[List[A]](key)