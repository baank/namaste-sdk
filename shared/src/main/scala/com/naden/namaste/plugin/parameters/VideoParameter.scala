package com.naden.namaste.plugin.parameters

import java.io.File

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class VideoParameter(key: String,
                          title: String,
                          description: String,
                          group: Option[String],
                          validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[File]
