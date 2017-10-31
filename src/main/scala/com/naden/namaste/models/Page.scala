package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.PageType
import com.naden.namaste.plugin.util.RandomUtils

case class Page(names: Map[Locale, String],
                descriptions: Map[Locale, String],
                createdBy: User,
                tags: Set[String],
                pageType: PageType,
                panels: Map[PanelSlot, Panel],
                linkId: String = RandomUtils.id(),
                parameterValues: Map[Parameter[_], _])
    extends Object(createdBy)
