package com.naden.namaste.plugin

import java.util.{Locale, ResourceBundle}

import com.naden.namaste.models.{Parameter, ServiceInstance}

trait Service {

  // Metadata
  def name(implicit locale: Locale): String = str("name")(locale)
  def description(implicit locale: Locale): String = str("description")(locale)

  def instanceParameters(): Seq[Parameter[_]] = Seq.empty
  def globalParameters(): Seq[Parameter[_]] = Seq.empty

  // Lifecycle
  def onStartup(): Unit = ()
  def onShutdown(): Unit = ()
  def onConfigured(instance: ServiceInstance[_]): Unit = ()

  // i18n
  def str(key: String)(implicit locale: Locale): String =
    ResourceBundle.getBundle(getClass().getName(), locale).getString(key)
}
