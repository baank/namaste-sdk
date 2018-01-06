package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class ListParameter[A](key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[A] = None,
                            validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[Seq[A]]
