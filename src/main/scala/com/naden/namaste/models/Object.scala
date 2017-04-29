package com.naden.namaste.models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class Object (createdBy: Option[User]) {

  val guid = UUID.randomUUID()
  val createTime = new Date()

  var status = Status.ACTIVE
  var updateTime = createTime
  var updatedBy = createdBy
  var version = 0L
  var icon = "Default.png"

}
