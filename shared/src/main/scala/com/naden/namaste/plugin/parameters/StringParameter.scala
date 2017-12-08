package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

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
    extends Parameter[String] {

  def validators = stringValidators
}
