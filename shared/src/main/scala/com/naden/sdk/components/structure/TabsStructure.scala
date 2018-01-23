package com.naden.sdk.components.structure

import boopickle.Default._

import com.naden.sdk.models.Component

case class TabsStructure(fixme: String) extends Component


object TabsStructure {
	implicit val pickler: Pickler[TabsStructure] = generatePickler[TabsStructure]
}