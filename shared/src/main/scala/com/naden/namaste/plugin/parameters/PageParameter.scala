package com.naden.namaste.plugin.parameters

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class PageParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String])
    extends Parameter[Page] {

  def options = Seq.empty
  def validators = Seq.empty[ParameterValidator]
}
