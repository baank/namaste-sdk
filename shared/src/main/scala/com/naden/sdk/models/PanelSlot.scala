package com.naden.sdk.models

import com.naden.sdk.plugin.services.PanelType

case class PanelSlot(createdBy: User,
                     panelType: PanelType,
                     minHeight: Int) extends Object(createdBy) {}
