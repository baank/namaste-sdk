package com.naden.namaste.plugin.util

import java.util.{Locale, ResourceBundle}

trait Localized {

  def name(implicit locale: Locale): String = str("name")(locale)
  def description(implicit locale: Locale): String = str("description")(locale)

  def str(key: String)(implicit locale: Locale): String =
    ResourceBundle.getBundle(getClass.getName, locale).getString(key)
}
