package com.naden.namaste.models

import scala.collection.mutable

case class Panel(var name: String, createdBy: Option[User]) extends Object(createdBy: Option[User]) {

  val values = mutable.Map[String, Any]()

}