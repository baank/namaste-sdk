package com.naden.namaste.models

import com.naden.namaste.plugin.PanelType

case class PanelSlot(createdBy: User, panelType: PanelType) extends Object(createdBy) {}
