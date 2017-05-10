package com.naden.namaste.models

case class PanelSlot(panelType: PanelType, createdBy: Option[User])
    extends Object(createdBy) {}
