package com.naden.namaste.models

import com.naden.namaste.plugin.util.RandomUtils

class Page(name: String,
           description: String,
           tags: Set[String],
           pageType: PageType,
           panels: Set[Panel],
           linkId: String = RandomUtils.id(),
           createdBy: Option[User])
    extends Object(createdBy)
