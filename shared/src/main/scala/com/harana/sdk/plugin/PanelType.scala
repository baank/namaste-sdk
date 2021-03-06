package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterName
import com.harana.sdk.models.{Component, ParameterValue}

trait PanelType extends Service {

  def scripts: List[String] = List.empty

  def stylesheets: List[String] = List.empty

  def userEditable: Boolean = true

  def layout(parameterValues: Map[ParameterName, ParameterValue]): List[Component]

  def layoutHasChanged: Boolean

  def allowUserRefresh: Boolean

}

object PanelType {
  type PanelTypeId = UUID
}