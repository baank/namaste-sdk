package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class StringParameter(key: String,
                           title: String,
                           description: String,
                           group: Option[String],
                           default: Option[String] = None,
                           idealLength: Option[(Int, Int)] = None,
                           maxLength: Option[Int] = None,
                           inputFormat: Option[String] = None,
                           options: Seq[String] = Seq(),
                           stringValidators: Seq[ParameterValidator] = Seq())()
    extends Parameter {

  def validators = stringValidators
}
