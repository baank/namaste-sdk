package com.naden.sdk.components.structure

import boopickle.Default._

import com.naden.sdk.models.Component

case class AccordionStructure(fixme: String) extends Component


object AccordionStructure {
	implicit val pickler: Pickler[AccordionStructure] = generatePickler[AccordionStructure]
}