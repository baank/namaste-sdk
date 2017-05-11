package com.naden.namaste.models

case class PanelSlot(panelType: PanelType, createdBy: User)
    extends Object(createdBy) {}
