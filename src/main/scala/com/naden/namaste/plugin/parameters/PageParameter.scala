package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class PageParameter(key: String)(implicit locale: Locale)
  extends LocalizedParameter[Page](key) {

  def options = Seq.empty
  def validators = Seq.empty[ParameterValidator]
}