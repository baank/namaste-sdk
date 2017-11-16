package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.LocalizedParameter

case class NewPasswordParameter(key: String)(implicit locale: Locale)
  extends LocalizedParameter[String](key) {

    def options = Seq.empty
    def validators = Seq.empty
}