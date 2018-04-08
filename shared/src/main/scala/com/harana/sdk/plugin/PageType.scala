package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Parameter.ParameterId
import com.harana.sdk.models.{Layout, ParameterValue}
import com.harana.sdk.plugin.PanelType.PanelTypeId

trait PageType extends Service {

  def detailLayout(parameterValues: Map[ParameterId, ParameterValue]): Layout

  def listLayout(parameterValues: Map[ParameterId, ParameterValue]): Layout

  def linkedPanelTypes: Set[PanelTypeId] = Set.empty

}

object PageType {
  type PageTypeId = UUID
}