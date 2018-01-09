package com.naden.sdk.plugin

trait ParameterValidator {
  def invalid(str: String): Option[String]
}
