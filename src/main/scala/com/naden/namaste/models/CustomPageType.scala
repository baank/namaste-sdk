package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.{PageType, PanelType}

case class CustomPageType(names: Map[Locale, String],
                          descriptions: Map[Locale, String],
                          createdBy: User,
                          override val listColumnWidths: Map[Int, Seq[Int]],
                          override val detailColumnWidths: Map[Int, Seq[Int]],
                          override val listPanels: Map[(Int, Int), Seq[PanelSlot]],
                          override val detailPanels: Map[(Int, Int), Seq[PanelSlot]],
                          override val linkedPanelTypes: Set[PanelType] = Set.empty,
                          override val parameters: Seq[Parameter[_]])
    extends Object(createdBy)
    with PageType {

  override def name(implicit locale: Locale): String = names.getOrElse(locale, "")
  override def description(implicit locale: Locale): String = descriptions.getOrElse(locale, "")
}
