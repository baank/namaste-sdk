package com.naden.namaste.plugin.parameters

import com.naden.namaste.models.TabularData
import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class TabularDataParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[TabularData]
