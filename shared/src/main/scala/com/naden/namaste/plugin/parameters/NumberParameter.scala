package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class NumberParameter[A](
    key: String,
    title: String,
    description: String,
    group: Option[String],
    default: Option[A] = None,
    options: Seq[A] = Seq(),
    validators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[A])
    extends Parameter[A]
