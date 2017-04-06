package models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class AtlasObject (createdBy: String) {

  // Unique id for this entity
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

}
