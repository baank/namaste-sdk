package com.naden.namaste.models

import com.naden.namaste.plugin.util.RandomUtils

case class Page(name: String, description: String, tags: Set[String], pageType: PageType, createdBy: Option[User]) extends Object(createdBy) {

  val linkId = RandomUtils.getId

}