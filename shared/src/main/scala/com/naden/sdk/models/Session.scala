package com.naden.sdk.models

import boopickle.Default._

case class Session()

object Session {
	implicit val pickler: Pickler[Session] = generatePickler[Session]
}