package com.naden.namaste.plugin

import com.naden.namaste.plugin.component._
import org.osgi.framework.{BundleActivator, BundleContext, ServiceRegistration}

import scala.collection.mutable.{ListBuffer => MutableList}

abstract class Plugin extends BundleActivator {

  def title: String
  def description: String
  def version: String

  def panelTypes(): Set[PanelType] = Set.empty
  def pageTypeCreators(): Set[PageTypeCreator] = Set.empty
  def pageImporters(): Set[PageImporter] = Set.empty
  def pageExporters(): Set[PageExporter] = Set.empty
  def storageServices(): Set[StorageService] = Set.empty
  def authenticationServices(): Set[AuthenticationService] = Set.empty
  def eventHandlers(): Set[EventHandler] = Set.empty
  def themes(): Set[Theme] = Set.empty
  def tasks(): Set[Task] = Set.empty
  def parameterValidators(): Set[ParameterValidator] = Set.empty

  private val serviceRegistrations = MutableList[(_ <: Component, ServiceRegistration[_])]()

  final override def start(context: BundleContext) = {
    println(s"""Starting plugin: $title""")

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
    println(s"""Stopping plugin: $title""")
    serviceRegistrations.foreach { service => service._2.unregister() ; service._1.onShutdown() }
  }
}
