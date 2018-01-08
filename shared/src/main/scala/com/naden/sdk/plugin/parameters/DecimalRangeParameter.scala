package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class DecimalRangeParameter(
    key: String,
    title: String,
    description: String,
    group: Option[String],
    default: Option[Int] = None,
    minimumValue: Int = 0,
    maximumValue: Int = 100,
    validators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[Int])
    extends Parameter {

  def options = Seq.empty
}
