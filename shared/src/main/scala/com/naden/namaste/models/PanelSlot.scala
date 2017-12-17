package com.naden.namaste.models

import com.naden.namaste.plugin.services.PanelType

case class PanelSlot(createdBy: User,
                     panelType: PanelType,
                     minHeight: Int) extends Object(createdBy) {}
