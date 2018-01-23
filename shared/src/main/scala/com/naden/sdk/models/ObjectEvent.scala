package com.naden.sdk.models

import boopickle.Default._

sealed trait ObjectEvent
object ObjectEvent {
	case object Created extends ObjectEvent
	case object Updated extends ObjectEvent
	case object Deleted extends ObjectEvent
}
