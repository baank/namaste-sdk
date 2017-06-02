package com.naden.namaste.models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class Object(createdBy: User) {

  val guid: UUID = UUID.randomUUID()
  val createTime: Date = new Date()
  val status = Status.ACTIVE
  val updateTime: Date = createTime
  val updatedBy: User = createdBy
  val version = 0L
  val icon = "Default.png"

  override def equals(o: Any): Boolean = o match {
    case that: Object => that.guid.equals(this.guid)
    case _ => false
  }

  override final def hashCode(): Int = guid.hashCode
}
