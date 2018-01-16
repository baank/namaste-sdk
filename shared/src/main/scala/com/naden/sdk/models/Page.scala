package com.naden.sdk.models

import com.naden.sdk.plugin.PageType
import com.naden.sdk.util.RandomUtils
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Page(createdBy: User,
                title: String,
                description: String,
                tags: Set[String],
                category: String,
                pageType: PageType,
                panels: List[(PanelSlot, Panel)],
                parameterValues: List[(Parameter, String)],
                linkId: String = RandomUtils.id(),
                parentPage: Option[Page] = None,
                subPages: Option[List[Page]] = None,
                linkedPages: List[(String, List[Page])] = List.empty)
    extends Object(createdBy)