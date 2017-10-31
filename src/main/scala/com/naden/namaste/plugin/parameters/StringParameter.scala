package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}
import com.naden.namaste.plugin.util.LocalizationUtils.str

case class StringParameter(key: String,
                           default: Option[String] = None,
                           optionKeys: Seq[String] = Seq(),
                           stringValidators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[String](key) {
  def options = optionKeys.map(o => (str(locale, s"$key.parameter.$o"), o))
  def validators = stringValidators
}