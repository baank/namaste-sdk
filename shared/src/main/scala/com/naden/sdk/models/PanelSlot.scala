package com.naden.sdk.models

import boopickle.Default._
import com.naden.sdk.plugin.PanelType
import com.naden.sdk.util.BoopickleCodecs._

case class PanelSlot(createdBy: User,
                     panelType: PanelType,
                     minHeight: Int) extends Object(createdBy) {}


object PanelSlot {
	implicit val pickler: Pickler[PanelSlot] = generatePickler[PanelSlot]
}