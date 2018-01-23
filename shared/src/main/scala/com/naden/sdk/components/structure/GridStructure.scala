package com.naden.sdk.components.structure

import boopickle.Default._

import com.naden.sdk.models.Component

case class GridStructure(fixme: String) extends Component


object GridStructure {
	implicit val pickler: Pickler[GridStructure] = generatePickler[GridStructure]
}