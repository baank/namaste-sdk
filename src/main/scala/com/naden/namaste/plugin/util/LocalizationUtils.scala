package com.naden.namaste.plugin.util

import java.util.{Locale, ResourceBundle}

object LocalizationUtils {
  def str(implicit locale: Locale, key: String): String =
    ResourceBundle.getBundle(getClass.getName, locale).getString(key)
}
