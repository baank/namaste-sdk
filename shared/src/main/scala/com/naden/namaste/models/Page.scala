package com.naden.namaste.models

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.PageType
import com.naden.namaste.util.RandomUtils

case class Page(createdBy: User,
                title: String,
                description: String,
                tags: Set[String],
                category: String,
                pageType: PageType,
                panels: Map[PanelSlot, Panel],
                parameterValues: Map[Parameter[_], _],
                linkId: String = RandomUtils.id(),
                parentPage: Option[Page] = None,
                subPages: Option[Seq[Page]] = None,
                linkedPages: Map[String, Seq[Page]] = Map.empty)
    extends Object(createdBy)
