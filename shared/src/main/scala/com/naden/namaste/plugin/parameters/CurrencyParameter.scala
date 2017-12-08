package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}
import squants.Money

case class CurrencyParameter(key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[String] = None,
                             options: Seq[Money] = Seq(),
                             validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[Money]
