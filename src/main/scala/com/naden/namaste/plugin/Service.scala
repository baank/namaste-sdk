package com.naden.namaste.plugin

import java.util.Locale

import com.naden.namaste.plugin.util.LocalizationUtils

abstract class Service {

  // Subclasses to override
  def instanceParameters: Seq[Parameter[_]]
  def globalParameters: Seq[Parameter[_]]
  def onStartup(): Unit
  def onShutdown(): Unit

  private var _context: Map[String, _] = Map.empty
  private var _locale: Locale = Locale.ENGLISH
  private var _parameterValues: Map[Parameter[_], _] = Map.empty

  implicit def locale = _locale

  def context = _context
  def parameterValues = _parameterValues

  final def onAppContextChange(newContext: Map[String, _]): Unit = { _context = newContext }
  final def onAppLocaleChange(newLocale: Locale): Unit = { _locale = newLocale }
  final def onUserConfigure(newParameterValues: Map[Parameter[_], _]): Unit = { _parameterValues = newParameterValues }

  def name: String = LocalizationUtils.str(_locale, "name")
  def description: String = LocalizationUtils.str(_locale, "description")
  def str(key: String): String = LocalizationUtils.str(_locale, key)
}

