package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.models.Parameter.ParameterId
import com.naden.sdk.models.Layout
import com.naden.sdk.plugin.PanelType.PanelTypeId

import scala.scalajs.reflect.annotation.EnableReflectiveInstantiation

trait PageType extends Service {

  def detailLayout(parameterValues: Map[ParameterId, String]): Layout

  def listLayout(parameterValues: Map[ParameterId, String]): Layout

  def linkedPanelTypes: Set[PanelTypeId] = Set.empty

}

object PageType {
  type PageTypeId = UUID
}