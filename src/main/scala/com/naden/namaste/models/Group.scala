package com.naden.namaste.models

import scala.collection.mutable

case class Group(name: String, createdBy: Option[User]) extends Object(createdBy) {

  var users = mutable.Set[User]()

}
