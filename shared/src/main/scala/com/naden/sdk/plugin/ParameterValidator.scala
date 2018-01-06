package com.naden.sdk.plugin

trait ParameterValidator {
  def invalid(item: Any): Option[String]
}
