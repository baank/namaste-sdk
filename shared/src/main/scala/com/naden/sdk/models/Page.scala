package com.naden.sdk.models

import com.naden.sdk.plugin.Parameter
import com.naden.sdk.plugin.services.PageType
import com.naden.sdk.util.RandomUtils

case class Page(createdBy: User,
                title: String,
                description: String,
                tags: Set[String],
                category: String,
                pageType: PageType,
                panels: Map[PanelSlot, Panel],
                parameterValues: Map[Parameter, _],
                linkId: String = RandomUtils.id(),
                parentPage: Option[Page] = None,
                subPages: Option[List[Page]] = None,
                linkedPages: Map[String, List[Page]] = Map.empty)
    extends Object(createdBy)
