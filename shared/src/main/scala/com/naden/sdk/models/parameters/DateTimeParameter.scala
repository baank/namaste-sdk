package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Parameter, ParameterValidator}
import org.threeten.bp.LocalDateTime

sealed trait DateTimeStyle
object DateTimeStyle {
	case object None extends DateTimeStyle
	case object Short extends DateTimeStyle
	case object Medium extends DateTimeStyle
	case object Long extends DateTimeStyle
	case object Full extends DateTimeStyle
}

case class DateTimeParameter(key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[LocalDateTime] = None,
                             required: Boolean,
                             dateOptions: List[LocalDateTime] = List(),
                             dateStyle: DateTimeStyle = DateTimeStyle.Short,
                             timeStyle: DateTimeStyle = DateTimeStyle.Short,
                             validators: List[ParameterValidator] = List()) extends Parameter

object DateTimeParameter {
	implicit val pickler: Pickler[DateTimeParameter] = generatePickler[DateTimeParameter]
}