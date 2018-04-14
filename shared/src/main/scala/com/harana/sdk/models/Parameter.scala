package com.harana.sdk.models

import com.harana.sdk.util.CirceCodecs._
import enumeratum._
import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

sealed trait DateTimeStyle extends EnumEntry
case object DateTimeStyle extends Enum[DateTimeStyle] with CirceEnum[DateTimeStyle] {
  case object None extends DateTimeStyle
  case object Short extends DateTimeStyle
  case object Medium extends DateTimeStyle
  case object Long extends DateTimeStyle
  case object Full extends DateTimeStyle
  val values = findValues
}

@EnableReflectiveInstantiation
trait Parameter {
  def name: String
	def title: String
  def description: String
  def group: Option[String]
  def required: Boolean
}

object Parameter {
	type ParameterName = String
}