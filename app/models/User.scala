package models

import scala.collection.mutable

class User(var firstName: String, var lastName: String, createdBy: String) extends Object(createdBy) {

  var groups = mutable.Set[Group]()

}
