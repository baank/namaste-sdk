package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class GeoAddressParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               validators: Seq[ParameterValidator] = Seq())()
    extends Parameter
