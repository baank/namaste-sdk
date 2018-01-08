package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class PageParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String])
    extends Parameter {

  def options = Seq.empty
  def validators = Seq.empty[ParameterValidator]
}
