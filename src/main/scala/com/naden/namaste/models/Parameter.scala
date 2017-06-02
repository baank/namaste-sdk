package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.ParameterValidator

case class Parameter[T](
    key: String,
    default: Option[Map[Locale, T]] = None,
    group: Option[Map[Locale, String]] = None,
    options: Seq[Map[Locale, T]] = Seq.empty[Map[Locale, T]],
    validators: Set[ParameterValidator] = Set.empty[ParameterValidator]
)
