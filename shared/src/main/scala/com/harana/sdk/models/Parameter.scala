package com.harana.sdk.models

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterId
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
  def description: String
  def group: Option[String]
  def required: Boolean
  def id: ParameterId
}

object Parameter {
	type ParameterId = UUID
}