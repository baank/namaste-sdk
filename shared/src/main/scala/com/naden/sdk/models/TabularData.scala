package com.naden.sdk.models

import com.naden.sdk.models.DataType.DataType

case class TabularData(columnTypes: List[DataType],
                       data: List[List[String]])

case object DataType extends Enumeration {
  type DataType = Value
  val Boolean = Value
  val Date = Value
  val Currency = Value
  val Password = Value
  val Percentage = Value
  val String = Value
}
