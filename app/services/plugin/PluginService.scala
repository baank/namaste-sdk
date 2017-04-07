package services.plugin

import scala.collection.mutable.ListBuffer

trait PluginService {

  def installPlugin(bundleLocation: String)

  def uninstallPlugin(bundleLocation: String)

  def removePlugin(pluginName: String)

  def copyPlugin(filePath: String)

  def findService[T <: AnyRef](clazz : Class[T], filter: String) : Option[T]

  def findServices[T <: AnyRef](clazz : Class[T], filter: String) : ListBuffer[Option[T]]

  def findService[T <: AnyRef](clazz : Class[T])

  def findServices[T <: AnyRef](clazz : Class[T])

  def createService[T <: AnyRef](service : T, properties: Map[String, Any])

}
