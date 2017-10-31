package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class NumberParameter[A](key: String,
                              default: Option[A] = None,
                              numberOptions: Seq[A] = Seq(),
                              numberValidators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[A], locale: Locale)
  extends LocalizedParameter[A](key) {
  def options = numberOptions.map(n => (n.toString, n))
  def validators = numberValidators
}