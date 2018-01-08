package com.naden.sdk.models

sealed trait ObjectEvent
object ObjectEvent {
	case object Created extends ObjectEvent
	case object Updated extends ObjectEvent
	case object Deleted extends ObjectEvent
}
