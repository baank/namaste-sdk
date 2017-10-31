package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class RelationshipParameter(key: String)(implicit locale: Locale)
  extends LocalizedParameter[Boolean](key) {
  def default = None
  def options = Seq.empty
  def validators = Seq.empty[ParameterValidator]
}