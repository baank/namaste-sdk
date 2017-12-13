package com.naden.namaste.plugin.services

import com.naden.namaste.models.{Layout, PanelSlot}
import com.naden.namaste.plugin.Service

trait PageType extends Service {

  def detailLayout: Layout[PanelSlot]
  def listLayout: Layout[PanelSlot]
  def linkedPanelTypes: Set[PanelType] = Set.empty

}
