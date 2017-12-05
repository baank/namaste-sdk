package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class HtmlParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[String] = None,
                         validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[String]
