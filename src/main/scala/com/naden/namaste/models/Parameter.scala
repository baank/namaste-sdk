package com.naden.namaste.models

import com.naden.namaste.plugin.component.ParameterValidator

case class Parameter[T](
  key: String,
  displayName: String,
  displayDescription: String,
  group: String,
  valueType: Class[T],
  validators: Set[ParameterValidator],
  defaultValue: T,
  possibleValues: Seq[(String, String)]
)