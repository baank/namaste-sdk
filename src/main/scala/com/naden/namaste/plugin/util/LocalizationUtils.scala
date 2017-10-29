package com.naden.namaste.plugin.util

import java.util.Locale

object LocalizationUtils {
  def str(implicit locale: Locale, key: String) = key
}
