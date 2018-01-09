package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class EmailParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          default: Option[String] = None,
                          validators: List[ParameterValidator] = List())()
    extends Parameter
