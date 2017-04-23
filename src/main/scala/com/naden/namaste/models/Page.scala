package com.naden.namaste.models

import com.naden.namaste.plugin.util.RandomUtils

case class Page(var name: String, var description: String, var tags: Set[String], pageType: PageType, createdBy: Option[User]) extends Object(createdBy) {

  val linkId = RandomUtils.getId

}