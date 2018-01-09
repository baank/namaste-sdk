package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class GeoLocationParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                validators: List[ParameterValidator] = List())()
    extends Parameter
