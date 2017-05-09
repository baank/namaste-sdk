package com.naden.namaste.models

class Panel(name: String,
            description: Option[String],
            panelType: PanelType,
            createdBy: Option[User])
    extends Object(createdBy) {}
