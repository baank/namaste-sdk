package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class GeoLocationParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[String]
