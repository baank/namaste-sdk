package com.naden.namaste.plugin

import java.util.Locale

import com.naden.namaste.plugin.util.LocalizationUtils.str

trait Parameter[T] {
  def key: String
  def name: String
  def description: String
  def default: Option[T]
  def group: Option[String]
  def options: Seq[(String, T)]
  def validators: Seq[ParameterValidator]
}

abstract class LocalizedParameter[T](key: String)(implicit locale: Locale) extends Parameter[T] {
  def name: String = str(locale, s"$key.name")
  def description: String = str(locale, s"$key.description")
  def group: Option[String] = Option(str(locale, s"$key.group"))
}