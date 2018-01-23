package com.naden.sdk.models

import boopickle.Default._
import com.naden.sdk.plugin.PanelType
import com.naden.sdk.util.BoopickleCodecs._

case class Panel(createdBy: User,
                 title: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: List[(Parameter, String)])
    extends Object(createdBy) {}

object Panel {
	implicit val pickler: Pickler[Panel] = generatePickler[Panel]
}