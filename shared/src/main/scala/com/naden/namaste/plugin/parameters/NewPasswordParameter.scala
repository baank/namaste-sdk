package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.Parameter

case class NewPasswordParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String])
    extends Parameter[String] {

  def options = Seq.empty
  def validators = Seq.empty
}
