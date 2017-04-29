package com.naden.namaste

import com.naden.namaste.plugin.component.ParameterValidator

case class Environment[T](
  var key: String,
  var displayName: String,
  var displayDescription: String,
  var valueType: Class[T],
  var validators: Set[ParameterValidator],
  var defaultValue: T,
  var predefinedValues: Seq[(String, String)]
)
