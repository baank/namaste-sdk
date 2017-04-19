package com.naden.namaste.models

import utils.RandomUtils

import scala.collection.mutable

case class Page(var name: String, pageType: PageType, createdBy: Option[User]) extends Object(createdBy) {

  val linkId = RandomUtils.getId

}