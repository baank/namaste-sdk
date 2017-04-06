package models

import scala.collection.mutable

class Group(var name: String, createdBy: String) extends AtlasObject(createdBy) {

  var users = mutable.Set[User]()

}
