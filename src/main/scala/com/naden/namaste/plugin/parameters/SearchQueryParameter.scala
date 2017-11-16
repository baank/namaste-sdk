package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.LocalizedParameter

case class SearchQueryParameter(key: String)(implicit locale: Locale)
  extends LocalizedParameter[String](key) {

  def validators = Seq.empty
}