package com.naden.namaste.models

case class Panel(name: String,
                 description: Option[String],
                 panelType: PanelType,
                 createdBy: User,
                 parameterValues: Map[String, _])
    extends Object(createdBy) {}
