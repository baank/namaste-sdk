package com.naden.namaste.plugin

trait ParameterValidator {
  def invalid(item: Any): Option[String]
}
