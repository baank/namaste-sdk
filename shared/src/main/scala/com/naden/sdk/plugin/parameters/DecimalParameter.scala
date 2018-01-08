package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class DecimalParameter(
    key: String,
    title: String,
    description: String,
    group: Option[String],
    default: Option[Int] = None,
    options: Seq[Int] = Seq(),
    validators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[Int])
    extends Parameter
