package com.naden.namaste.plugin.services

import com.naden.namaste.models.PanelSlot
import com.naden.namaste.plugin.Service

trait PageType extends Service {

  // Seq
  def listColumnWidths: Map[Int, Seq[Int]]
  def listStructure: Map[(Int, Int), Seq[PanelSlot]]

  // Detail
  def detailColumnWidths: Map[Int, Seq[Int]]
  def detailStructure: Map[(Int, Int), Seq[PanelSlot]]

  def linkedPanelTypes: Set[PanelType] = Set.empty

}
