package models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class Object (createdBy: Option[User]) {

  // Unique id for this ViewEntity
  val guid = UUID.randomUUID()

  // Status
  var status = Status.ACTIVE

  // Create Time
  val createTime = new Date()

  // Update Time
  var updateTime = createTime

  // Updated By
  var updatedBy = createdBy

  // Version
  var version = 0L

  // Icon
  var icon = "Default.png"
}
