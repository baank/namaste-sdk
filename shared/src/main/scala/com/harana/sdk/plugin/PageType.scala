package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterName
import com.harana.sdk.models.{Layout, ParameterValue}
import com.harana.sdk.plugin.PanelType.PanelTypeId

trait PageType extends Service {

  def detailLayout(parameterValues: Map[ParameterName, ParameterValue]): Layout

  def listLayout(parameterValues: Map[ParameterName, ParameterValue]): Layout

  def linkedPanelTypes: Set[PanelTypeId] = Set.empty

}

object PageType {
  type PageTypeId = UUID
}