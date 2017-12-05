package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class URLParameter[URL](key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[URL] = None,
                             validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[URL]
