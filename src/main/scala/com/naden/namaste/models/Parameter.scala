package com.naden.namaste.models

case class Parameter[T](
    key: String,
    defaultValue: Option[T] = None,
    group: Option[String] = None,
    options: Seq[String] = Seq.empty[String],
    validators: Set[ParameterValidator] = Set.empty[ParameterValidator]
)
