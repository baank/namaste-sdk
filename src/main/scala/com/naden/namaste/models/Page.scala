package com.naden.namaste.models

import com.naden.namaste.plugin.util.RandomUtils

case class Page(name: String,
                description: String,
                tags: Set[String],
                pageType: PageType,
                panels: Map[PanelSlot, Panel],
                linkId: String = RandomUtils.id(),
                createdBy: User)
    extends Object(createdBy)
