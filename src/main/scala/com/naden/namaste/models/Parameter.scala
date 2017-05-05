package com.naden.namaste.models

import com.naden.namaste.plugin.component.ParameterValidator

case class Parameter[T](
  key: String,
  defaultValue: Option[T] = None,
  group: Option[String] = None,
  options: Seq[String] = Seq.empty[String],
  validators: Set[ParameterValidator] = Set.empty[ParameterValidator]
)