package com.naden.sdk.components.structure

import boopickle.Default._

import com.naden.sdk.models.Component

case class PillsStructure(fixme: String) extends Component


object PillsStructure {
	implicit val pickler: Pickler[PillsStructure] = generatePickler[PillsStructure]
}