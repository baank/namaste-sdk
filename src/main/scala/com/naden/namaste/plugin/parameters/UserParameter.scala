package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.LocalizedParameter

case class UserParameter(key: String)(implicit locale: Locale)
  extends LocalizedParameter[String](key) {

  def default = None
  def options = Seq.empty
  def validators = Seq.empty

}