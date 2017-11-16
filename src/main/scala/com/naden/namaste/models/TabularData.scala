package com.naden.namaste.models

import com.naden.namaste.models.DataType.DataType

case class TabularData(columnTypes: List[DataType], data: List[List[String]])

object DataType extends Enumeration {
  type DataType = Value
  val Boolean = Value
  val Date = Value
  val Currency = Value
  val Password = Value
  val Percentage = Value
  val String = Value
}
