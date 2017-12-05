package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class GeoAddressParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[String]
