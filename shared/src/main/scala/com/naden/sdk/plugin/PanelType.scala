package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.Component
import com.naden.sdk.plugin.PanelType.PanelTypeId

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

trait PanelType extends Service {

  def scripts: List[String] = List.empty

  def stylesheets: List[String] = List.empty

  def userEditable: Boolean = true

  def layout(parameterValues: Map[ParameterId, String]): List[Component]

  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean

}

object PanelType {
  type PanelTypeId = UUID
}