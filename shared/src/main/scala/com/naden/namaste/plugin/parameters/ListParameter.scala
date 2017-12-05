package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class ListParameter[A](key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[A] = None,
                            validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[List[A]]
