package com.naden.namaste.models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class Object(createdBy: Option[User],
                      createTime: Date = new Date(),
                      newGuid: UUID = UUID.randomUUID()) {

  val guid: UUID = newGuid
  val status = Status.ACTIVE
  val updateTime = createTime
  val updatedBy = createdBy
  val version = 0L
  val icon = "Default.png"
}
