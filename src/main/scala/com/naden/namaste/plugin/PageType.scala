package com.naden.namaste.plugin

import com.naden.namaste.models.PanelSlot
import com.naden.namaste.plugin.util.Localized

trait PageType extends Localized {

  // Seq
  def listColumnWidths: Map[Int, Seq[Int]]
  def listPanels: Map[(Int, Int), Seq[PanelSlot]]

  // Detail
  def detailColumnWidths: Map[Int, Seq[Int]]
  def detailPanels: Map[(Int, Int), Seq[PanelSlot]]

  def linkedPanelTypes: Set[PanelType] = Set.empty

  // Parameters
  def parameters: Seq[Parameter[_]]
}
