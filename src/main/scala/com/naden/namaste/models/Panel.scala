package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.PanelType

case class Panel(names: Map[Locale, String],
                 descriptions: Map[Locale, String],
                 createdBy: User,
                 panelType: PanelType,
                 parameterValues: Map[Parameter[_], _])
    extends Object(createdBy) {}
