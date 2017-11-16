package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.LocalizedParameter

case class BooleanParameter(key: String,
                            default: Option[Boolean] = None)(implicit locale: Locale)
  extends LocalizedParameter[Boolean](key) {

  def validators = Seq.empty
}