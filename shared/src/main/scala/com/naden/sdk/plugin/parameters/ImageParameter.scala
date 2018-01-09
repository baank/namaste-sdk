package com.naden.sdk.plugin.parameters

import java.io.File

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class ImageParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          validators: List[ParameterValidator] = List())()
    extends Parameter
