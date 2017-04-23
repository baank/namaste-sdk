package com.naden.namaste.models

import com.naden.namaste.plugin.component.PanelType

import scala.collection.mutable

case class Panel(var name: String, createdBy: Option[User], panelType: PanelType) extends Object(createdBy: Option[User]) {

  val parameterValues = mutable.Map[String, Any]()

}
