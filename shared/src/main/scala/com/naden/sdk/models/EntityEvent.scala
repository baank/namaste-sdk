package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
sealed trait ObjectEvent
object ObjectEvent {
	case object Created extends ObjectEvent
	case object Updated extends ObjectEvent
	case object Deleted extends ObjectEvent
}
