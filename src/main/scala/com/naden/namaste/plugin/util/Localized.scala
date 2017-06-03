package com.naden.namaste.plugin.util

import java.util.{Locale, ResourceBundle}

trait Localized {

  def name(implicit locale: Locale): String = str(locale, "name")
  def description(implicit locale: Locale): String = str(locale, "description")

  def str(implicit locale: Locale, key: String): String =
    ResourceBundle.getBundle(getClass.getName, locale).getString(key)

}
