package com.naden.namaste.models

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.PanelType

case class Panel(createdBy: User,
                 name: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: Map[Parameter[_], _])
    extends Object(createdBy) {}
