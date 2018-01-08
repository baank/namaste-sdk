package com.naden.sdk.models

case class TabularData(columnTypes: List[DataType],
                       data: List[List[String]])

sealed trait DataType
object DataType {
  case object Boolean extends DataType
  case object Date extends DataType
  case object Currency extends DataType
  case object Password extends DataType
  case object Percentage extends DataType
  case object String extends DataType
}
