package com.naden.namaste.models

import scala.collection.mutable

case class User(var firstName: String, var lastName: String, emailAddress: String, createdBy: Option[User]) extends Object(createdBy) {

  var groups = mutable.Set[Group]()

  def addToGroups(newGroups: Group*) = {
    newGroups.foreach { group =>
        groups += group
        group.users += this
    }
  }
}
