package com.naden.sdk.models

import com.naden.sdk.plugin.PanelType
import boopickle.Default._

case class Panel(createdBy: User,
                 title: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: List[(Parameter, String)])
    extends Object(createdBy) {}

object Panel {
	implicit val pickler: Pickler[Panel] = generatePickler[Panel]
}