package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.models.Connection
import com.naden.namaste.plugin.LocalizedParameter

case class ConnectionParameter(key: String,
                           default: Option[Connection] = None)(implicit locale: Locale)
  extends LocalizedParameter[Connection](key) {

  def validators = Seq.empty
}