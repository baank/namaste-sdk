package com.naden.sdk.components.maps

import boopickle.Default._

import com.naden.sdk.models.Component

case class VectorMap(fixme: String) extends Component


object VectorMap {
	implicit val pickler: Pickler[VectorMap] = generatePickler[VectorMap]
}