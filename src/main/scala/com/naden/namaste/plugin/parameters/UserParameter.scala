package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.models.User
import com.naden.namaste.plugin.LocalizedParameter

case class UserParameter(key: String)(implicit locale: Locale)
  extends LocalizedParameter[User](key) {

  def validators = Seq.empty
}