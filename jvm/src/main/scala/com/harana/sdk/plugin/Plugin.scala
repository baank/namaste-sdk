package com.harana.sdk.plugin

import com.harana.sdk.plugin.Service.ServiceId
import org.osgi.framework.{BundleActivator, BundleContext, ServiceRegistration}

import scala.collection.JavaConverters._
import scala.collection.mutable
import scala.collection.mutable.{ListBuffer => MutableList}

abstract class Plugin extends BundleActivator {

  def ids: Map[Class[_ <: Service], ServiceId]
  def version: (Int, Int, Int)

	def authenticationServices: Set[Class[_ <: AuthenticationService]]
	def backupTypes: Set[Class[_ <: BackupType]]
	def connectionTypes: Set[Class[_ <: ConnectionType]]
	def eventHandlers: Set[Class[_ <: EventHandler]]
	def healthChecks: Set[Class[_ <: HealthCheck]]
	def notificationTypes: Set[Class[_ <: NotificationType]]
	def pageExporters: Set[Class[_ <: PageExporter]]
	def pageImporters: Set[Class[_ <: PageImporter]]
  def pageTypes: Set[Class[_ <: PageType]]
	def pageTypeSuppliers: Set[Class[_ <: PageTypeSupplier]]
	def panelTypes: Set[Class[_ <: PanelType]]
	def storageServices: Set[Class[_ <: StorageService]]
	def tasks: Set[Class[_ <: Task]]
  def themes: Set[Class[_ <: Theme]]

  private val serviceRegistrations = MutableList[(_, ServiceRegistration[_])]()

  final override def start(context: BundleContext): Unit = {
	  register[AuthenticationService](context, classOf[AuthenticationService], authenticationServices)
	  register[BackupType](context, classOf[BackupType], backupTypes)
	  register[ConnectionType](context, classOf[ConnectionType], connectionTypes)
	  register[EventHandler](context, classOf[EventHandler], eventHandlers)
	  register[HealthCheck](context, classOf[HealthCheck], healthChecks)
	  register[NotificationType](context, classOf[NotificationType], notificationTypes)
	  register[PageExporter](context, classOf[PageExporter], pageExporters)
	  register[PageImporter](context, classOf[PageImporter], pageImporters)
	  register[PageType](context, classOf[PageType], pageTypes)
	  register[PageTypeSupplier](context, classOf[PageTypeSupplier], pageTypeSuppliers)
	  register[PanelType](context, classOf[PanelType], panelTypes)
	  register[StorageService](context, classOf[StorageService], storageServices)
	  register[Task](context, classOf[Task], tasks)
	  register[Theme](context, classOf[Theme], themes)
  }

  private def register[T <: Service](context: BundleContext, cls: Class[T], services: Set[Class[_ <: T]]): Unit = {
    try {
      services.foreach { service =>
        // TODO harden if no ids etc.
        val map = mutable.Map("id" -> ids(service))
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