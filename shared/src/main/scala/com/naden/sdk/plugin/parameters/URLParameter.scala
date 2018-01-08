package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class URLParameter[URL](key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[URL] = None,
                             validators: Seq[ParameterValidator] = Seq())()
    extends Parameter
