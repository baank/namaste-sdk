package com.naden.sdk.plugin

import com.naden.sdk.plugin.Service.ServiceId
import org.osgi.framework.{BundleActivator, BundleContext, ServiceRegistration}

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.collection.mutable.{ListBuffer => MutableList}

abstract class Plugin extends BundleActivator {

  def ids: Map[Class[_ <: Service], ServiceId]

  def version: (Int, Int, Int)

  def panelTypes: Set[Class[_ <: PanelType]]

  def pageTypes: Set[Class[_ <: PageType]]

  def pageImporters: Set[Class[_ <: PageImporter]]

  def pageExporters: Set[Class[_ <: PageExporter]]

  def storageServices: Set[Class[_ <: StorageService]]

  def authenticationServices: Set[Class[_ <: AuthenticationService]]

  def eventHandlers: Set[Class[_ <: EventHandler]]

  def themes: Set[Class[_ <: Theme]]

  def tasks: Set[Class[_ <: Task]]

  private val serviceRegistrations = MutableList[(_, ServiceRegistration[_])]()

  final override def start(context: BundleContext): Unit = {
    register[PanelType](context, classOf[PanelType], panelTypes)
    register[PageType](context, classOf[PageType], pageTypes)
    register[PageImporter](context, classOf[PageImporter], pageImporters)
    register[PageExporter](context, classOf[PageExporter], pageExporters)
    register[StorageService](context, classOf[StorageService], storageServices)
    register[AuthenticationService](context, classOf[AuthenticationService], authenticationServices)
    register[EventHandler](context, classOf[EventHandler], eventHandlers)
    register[Theme](context, classOf[Theme], themes)
    register[Task](context, classOf[Task], tasks)
  }

  private def register[T <: Service](context: BundleContext,
                          cls: Class[T],
                          services: Set[Class[_ <: T]]): Unit = {
    try {
      services.foreach { service =>
        val map = mutable.Map("id" -> ids(cls))
        serviceRegistrations += service -> context.registerService(cls, service.newInstance(), map.asJavaDictionary)
        //TODO
        //service.asInstanceOf[Service].onStartup()
      }
    } catch {
      case e: Exception => {
        e.printStackTrace()
        println("Failed to register services of type: " + cls)
      }
    }
  }

  final override def stop(context: BundleContext): Unit = {
    serviceRegistrations.foreach { service =>
      service._2.unregister()
      //    TODO
      //      service._1 match {
      //        case s: Service => s.onShutdown()
      //      }
    }
  }
}