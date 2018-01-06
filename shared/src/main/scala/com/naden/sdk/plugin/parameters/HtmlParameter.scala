package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class HtmlParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[String] = None,
                         validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[String]
