package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class NewPasswordParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String])
    extends Parameter {

  def options = List.empty
  def validators = List.empty
}
