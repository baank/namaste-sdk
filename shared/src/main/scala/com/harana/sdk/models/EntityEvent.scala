package com.harana.sdk.models

import enumeratum._

sealed trait EntityEvent extends EnumEntry
case object EntityEvent extends Enum[EntityEvent] with CirceEnum[EntityEvent] {
	case object Created extends EntityEvent
	case object Updated extends EntityEvent
	case object Deleted extends EntityEvent
	val values = findValues
}
