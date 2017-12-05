package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class TagsParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[String] = None,
                         limit: Option[Int] = None,
                         allowDuplicates: Boolean = true,
                         validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[List[String]]
