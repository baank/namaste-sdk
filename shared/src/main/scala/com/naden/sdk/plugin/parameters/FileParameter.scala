package com.naden.sdk.plugin.parameters

import java.io.File

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class FileParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         validators: Seq[ParameterValidator] = Seq())()
    extends Parameter {}
