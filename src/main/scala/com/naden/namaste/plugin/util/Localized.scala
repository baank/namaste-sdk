package com.naden.namaste.plugin.util

import java.util.Locale

trait Localized {

  def name(implicit locale: Locale): String = LocalizationUtils.str(locale, "name")
  def description(implicit locale: Locale): String = LocalizationUtils.str(locale, "description")
}
