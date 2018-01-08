package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class TagsParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[String] = None,
                         limit: Option[Int] = None,
                         allowDuplicates: Boolean = true,
                         validators: Seq[ParameterValidator] = Seq())()
    extends Parameter
