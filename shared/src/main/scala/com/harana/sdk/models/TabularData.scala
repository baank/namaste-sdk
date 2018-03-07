package com.harana.sdk.models

import io.circe.generic.JsonCodec
import enumeratum._

@JsonCodec
case class TabularData(columnTypes: List[DataType],
                       data: List[List[String]])

sealed trait DataType extends EnumEntry
case object DataType extends Enum[DataType] with CirceEnum[DataType] {
  case object Boolean extends DataType
  case object Date extends DataType
  case object Currency extends DataType
  case object Password extends DataType
  case object Percentage extends DataType
  case object String extends DataType
  val values = findValues
}
