package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
sealed trait EntityEvent
object EntityEvent {
	case object Created extends EntityEvent
	case object Updated extends EntityEvent
	case object Deleted extends EntityEvent
}
