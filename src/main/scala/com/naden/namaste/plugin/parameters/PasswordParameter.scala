package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class PasswordParameter(key: String,
                           validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[String](key) {

    def options = Seq.empty
}