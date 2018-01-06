package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class NumberRangeParameter[A](
    key: String,
    title: String,
    description: String,
    group: Option[String],
    default: Option[A] = None,
    minimumValue: Int = 0,
    maximumValue: Int = 100,
    validators: Seq[ParameterValidator] = Seq())(implicit num: Numeric[A])
    extends Parameter[(A, A)] {

  def options = Seq.empty
}
