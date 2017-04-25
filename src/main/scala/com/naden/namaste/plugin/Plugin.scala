package com.naden.namaste.plugin

import com.naden.namaste.plugin.component._
import org.osgi.framework.{BundleActivator, BundleContext, ServiceRegistration}

import scala.collection.mutable.{ListBuffer => MutableList}

abstract class Plugin extends BundleActivator {

  def shortName: String
  def longName: String
  def description: String
  def version: String

  def panelTypes(): Set[PanelType]
  def pageTypeCreators(): Set[PageTypeCreator]
  def pageImporters(): Set[PageImporter]
  def pageExporters(): Set[PageExporter]
  def storageServices(): Set[StorageService]
  def authenticationServices(): Set[AuthenticationService]
  def eventHandlers(): Set[EventHandler]
  def themes(): Set[Theme]
  def tasks(): Set[Task]
  def parameterValidators(): Set[ParameterValidator]

  private val serviceRegistrations = MutableList[(_ <: Component, ServiceRegistration[_])]()

  final override def start(context: BundleContext) = {
    println(s"""Starting plugin: $shortName""")

    if (panelTypes != null) panelTypes.foreach { panelType => serviceRegistrations += panelType -> context.registerService(classOf[PanelType], panelType, null) ; panelType.onStartup() }
    if (pageTypeCreators != null) pageTypeCreators.foreach { pageTypeCreator => serviceRegistrations += pageTypeCreator -> context.registerService(classOf[PageTypeCreator], pageTypeCreator, null) ; pageTypeCreator.onStartup() }
    if (pageImporters != null) pageImporters.foreach { pageImporter => serviceRegistrations += pageImporter -> context.registerService(classOf[PageImporter], pageImporter, null) ; pageImporter.onStartup() }
    if (pageExporters != null) pageExporters.foreach { pageExporter => serviceRegistrations += pageExporter -> context.registerService(classOf[PageExporter], pageExporter, null) ; pageExporter.onStartup() }
    if (storageServices != null) storageServices.foreach { storageService => serviceRegistrations += storageService -> context.registerService(classOf[StorageService], storageService, null) ; storageService.onStartup() }
    if (authenticationServices != null) authenticationServices.foreach { authenticationService => serviceRegistrations += (authenticationService -> context.registerService(classOf[AuthenticationService], authenticationService, null)) ; authenticationService.onStartup() }
    if (eventHandlers != null) eventHandlers.foreach { eventHandler => serviceRegistrations += eventHandler -> context.registerService(classOf[EventHandler], eventHandler, null) ; eventHandler.onStartup() }
    if (themes != null) themes.foreach { theme => serviceRegistrations += theme -> context.registerService(classOf[Theme], theme, null) ; theme.onStartup() }
    if (tasks != null) tasks.foreach { task => serviceRegistrations += task -> context.registerService(classOf[Task], task, null) ; task.onStartup() }
    if (parameterValidators != null) parameterValidators.foreach { parameterValidator => serviceRegistrations += parameterValidator -> context.registerService(classOf[ParameterValidator], parameterValidator, null) ; parameterValidator.onStartup() }
  }

  final override def stop(context: BundleContext) = {
    println(s"""Stopping plugin: $shortName""")
    serviceRegistrations.foreach { service => service._2.unregister() ; service._1.onShutdown() }
  }
}
