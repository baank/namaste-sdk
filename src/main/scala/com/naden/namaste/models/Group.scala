package com.naden.namaste.models

import scala.collection.mutable

case class Group(var name: String, createdBy: Option[User]) extends Object(createdBy) {

  var users = mutable.Set[User]()

}
