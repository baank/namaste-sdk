package com.naden.sdk.models

import boopickle.Default._

case object ObjectEvent extends Enumeration {
	type ObjectEvent = Value

	val Created = Value("Added")
	val Updated = Value("Updated")
	val Deleted = Value("Deleted")
}
