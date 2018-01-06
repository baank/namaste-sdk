package com.naden.sdk.models

import com.naden.sdk.plugin.Parameter
import com.naden.sdk.plugin.services.PanelType

case class Panel(createdBy: User,
                 title: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: Map[Parameter[_], _])
    extends Object(createdBy) {}
