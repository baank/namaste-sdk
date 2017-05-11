package com.naden.namaste.models

import java.util.{Date, UUID}

object Status extends Enumeration { val ACTIVE, DELETED = Value }

abstract class Object(createdBy: User) {

  lazy val guid: UUID = UUID.randomUUID()
  lazy val createTime: Date = new Date()
  lazy val status = Status.ACTIVE
  lazy val updateTime = createTime
  lazy val updatedBy = createdBy
  lazy val version = 0L
  lazy val icon = "Default.png"

  override def equals(o: Any) = o match {
    case that: Object => that.guid.equals(this.guid)
    case _ => false
  }

  override final def hashCode(): Int = guid.hashCode
}
