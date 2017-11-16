package com.naden.namaste.plugin.parameters

import java.util.Locale
import javax.money.MonetaryAmount

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class CurrencyParameter(key: String,
                           default: Option[String] = None,
                           options: Seq[MonetaryAmount] = Seq(),
                           validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[MonetaryAmount](key)