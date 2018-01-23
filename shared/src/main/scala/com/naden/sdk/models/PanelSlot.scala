package com.naden.sdk.models

import com.naden.sdk.plugin.PanelType
import boopickle.Default._

case class PanelSlot(createdBy: User,
                     panelType: PanelType,
                     minHeight: Int) extends Object(createdBy) {}


object PanelSlot {
	implicit val pickler: Pickler[PanelSlot] = generatePickler[PanelSlot]
}