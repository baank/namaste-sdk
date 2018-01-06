package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}
import squants.Money

case class CurrencyParameter(key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[String] = None,
                             options: Seq[Money] = Seq(),
                             validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[Money]
