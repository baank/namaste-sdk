package com.naden.namaste.models

import com.naden.namaste.plugin.component.ParameterValidator

case class Parameter[T](
  var key: String,
  var displayName: String,
  var displayDescription: String,
  var valueType: Class[T],
  var validators: Option[Set[ParameterValidator]],
  var defaultValue: T,
  var predefinedValues: Option[Seq[(String, String)]]
)