package com.naden.namaste.models

import java.util.Locale

import com.naden.namaste.plugin.Parameter
import com.naden.namaste.plugin.services.{PageType, PanelType}

case class UserPageType(names: Map[Locale, String],
                        descriptions: Map[Locale, String],
                        createdBy: User,
                        override val listColumnWidths: Map[Int, Seq[Int]],
                        override val detailColumnWidths: Map[Int, Seq[Int]],
                        override val listPanels: Map[(Int, Int), Seq[PanelSlot]],
                        override val detailPanels: Map[(Int, Int), Seq[PanelSlot]],
                        override val linkedPanelTypes: Set[PanelType] = Set.empty,
                        val parameters: Seq[Parameter[_]])
    extends PageType {

  override def name: String = names.getOrElse(locale, "")
  override def description: String = descriptions.getOrElse(locale, "")

  // TODO
  override def instanceParameters = Seq.empty
  override def globalParameters = Seq.empty

  override def onStartup(): Unit = {}
  override def onShutdown(): Unit = {}
}
