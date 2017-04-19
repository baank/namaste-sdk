package main.scala.com.naden.namaste.plugin

import com.naden.namaste.plugin.types.{PanelPluginType, _}
import com.naden.namaste.types._

trait NamastePlugin {

  def panelTypes(): Option[Set[PanelPluginType]]

  def pageTypeCreators(): Option[Set[PagePluginTypeCreator]]

  def pageImporters(): Option[Set[PageImporter]]

  def pageExporters(): Option[Set[PageExporter]]

  def storageServices(): Option[Set[StorageService]]

  def authenticationServices(): Option[Set[AuthenticationService]]

  def eventHandlers(): Option[Set[EventHandler]]

  def themes(): Option[Set[Theme]]

}
