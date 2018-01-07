package com.naden.sdk.models

import com.naden.sdk.plugin.services.PanelType
import boopickle.Default._

case class PanelSlot(createdBy: User,
                     panelType: PanelType,
                     minHeight: Int) extends Object(createdBy) {}
