package com.naden.namaste.plugin

import com.naden.namaste.models._
import com.naden.namaste.plugin.services._
import org.osgi.framework.{BundleActivator, BundleContext, ServiceRegistration}

import scala.collection.mutable.{ListBuffer => MutableList}

abstract class Plugin extends BundleActivator {

  def title: String
  def description: String
  def version: String

  def panelTypes(): Set[PanelType] = Set.empty
  def pageTypes(): Set[PageType] = Set.empty
  def pageImporters(): Set[PageImporter] = Set.empty
  def pageExporters(): Set[PageExporter] = Set.empty
  def storageServices(): Set[StorageService] = Set.empty
  def authenticationServices(): Set[AuthenticationService] = Set.empty
  def eventHandlers(): Set[EventHandler] = Set.empty
  def themes(): Set[Theme] = Set.empty
  def tasks(): Set[Task] = Set.empty
  def parameterValidators(): Set[ParameterValidator] = Set.empty

  private val serviceRegistrations = MutableList[(_, ServiceRegistration[_])]()

  final override def start(context: BundleContext): Unit = {
    println(s"""Starting plugin services: $title""")

    register(context, classOf[PanelType], panelTypes)
    register(context, classOf[PageType], pageTypes, false)
    register(context, classOf[PageImporter], pageImporters)
    register(context, classOf[PageExporter], pageExporters)
    register(context, classOf[StorageService], storageServices)
    register(context, classOf[AuthenticationService], authenticationServices)
    register(context, classOf[EventHandler], eventHandlers)
    register(context, classOf[Theme], themes, false)
    register(context, classOf[Task], tasks, false)
  }

  private def register[T](context: BundleContext,
                          cls: Class[T],
                          services: Set[T],
                          lifecycle: Boolean = true) = {
    try {
      services.foreach { service =>
        serviceRegistrations += service -> context.registerService(cls,
                                                                   service,
                                                                   null)
        if (lifecycle) service.asInstanceOf[Service].onStartup();
      }
    } catch {
      case e: Exception =>
        println("Failed to register services of type: " + cls)
    }
  }

  final override def stop(context: BundleContext): Unit = {
    println(s"""Stopping plugin services: $title""")
    serviceRegistrations.foreach { service =>
      service._2.unregister()
      service._1 match {
        case s: Service => s.onShutdown()
      }
    }
  }
}
