package com.naden.namaste.plugin.services

import com.naden.namaste.models.{Layout, PanelSlot}
import com.naden.namaste.plugin.{Parameter, Service}

trait PageType extends Service {

  def detailLayout(parameterValues: Map[Parameter[_], _]): Layout[PanelSlot]

  def listLayout(parameterValues: Map[Parameter[_], _]): Layout[PanelSlot]

  def linkedPanelTypes: Set[PanelType] = Set.empty

}
