package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class NumberRangeParameter[A](key: String,
                                default: Option[A] = None,
                                minimumValue: Int = 0,
                                maximumValue: Int = 100,
                                validators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[A], locale: Locale)
  extends LocalizedParameter[(A,A)](key) {

  def options = Seq.empty
}