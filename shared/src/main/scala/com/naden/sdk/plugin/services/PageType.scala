package com.naden.sdk.plugin.services

import com.naden.sdk.models.{Layout, PanelSlot}
import com.naden.sdk.plugin.{Parameter, Service}

trait PageType extends Service {

  def detailLayout(parameterValues: Map[Parameter, _]): Layout[PanelSlot]

  def listLayout(parameterValues: Map[Parameter, _]): Layout[PanelSlot]

  def linkedPanelTypes: Set[PanelType] = Set.empty

}
