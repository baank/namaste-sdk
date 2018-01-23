package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.Component

case class TagsList(fixme: String) extends Component


object TagsList {
	implicit val pickler: Pickler[TagsList] = generatePickler[TagsList]
}