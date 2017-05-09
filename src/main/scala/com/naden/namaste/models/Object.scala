package com.naden.namaste.models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class Object(createdBy: Option[User],
                      guid: UUID = UUID.randomUUID(),
                      createTime: Date = new Date()) {

  val status = Status.ACTIVE
  val updateTime = createTime
  val updatedBy = createdBy
  val version = 0L
  val icon = "Default.png"
}
