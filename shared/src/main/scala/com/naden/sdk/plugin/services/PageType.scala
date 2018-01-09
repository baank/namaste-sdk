package com.naden.sdk.plugin.services

import com.naden.sdk.models.{Layout, PanelSlot}
import com.naden.sdk.plugin.{Parameter, Service}

trait PageType extends Service {

  def detailLayout(parameterValues: List[(Parameter, String)]): Layout[PanelSlot]

  def listLayout(parameterValues: List[(Parameter, String)]): Layout[PanelSlot]

  def linkedPanelTypes: Set[PanelType] = Set.empty

}
