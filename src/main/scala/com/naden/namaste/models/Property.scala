package com.naden.namaste.models

case class Property[T](
  var key: String,
  var displayName: String,
  var displayDescription: String,
  var valueType: Class[T],
  var maxLength: Option[Int],
  var predefinedValues: Option[Seq[(String, String)]]
)
