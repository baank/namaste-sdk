package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class NumberRangeParameter[A](
    key: String,
    title: String,
    description: String,
    group: Option[String],
    default: Option[A] = None,
    minimumValue: A = 0,
    maximumValue: A = 100,
    validators: List[ParameterValidator] = List())(implicit num: Numeric[A])
    extends Parameter {

  def options = List.empty
}
