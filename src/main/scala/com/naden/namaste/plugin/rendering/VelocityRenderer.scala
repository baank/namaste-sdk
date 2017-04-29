
package com.naden.namaste.plugin.rendering

import java.io.StringWriter
import java.util.{Properties, Iterator => JavaIterator}

import com.naden.namaste.plugin.rendering.ScalaUberspect.{ScalaMapGetExecutor, ScalaPropertyExecutor}
import org.apache.velocity.app.VelocityEngine
import org.apache.velocity.runtime.log.Log
import org.apache.velocity.runtime.parser.node.MapGetExecutor
import org.apache.velocity.runtime.parser.node.PropertyExecutor
import org.apache.velocity.util.introspection.UberspectImpl.VelGetterImpl
import org.apache.velocity.util.introspection.Info
import org.apache.velocity.util.introspection.Introspector
import org.apache.velocity.util.introspection.UberspectImpl
import org.apache.velocity.util.introspection.VelPropertyGet
import org.apache.velocity.VelocityContext

object VelocityRenderer {

  lazy val engine: VelocityEngine = {
    val prop = new Properties
    prop.put("runtime.introspector.uberspect", "com.naden.namaste.plugin.rendering.ScalaUberspect")

    val engine = new VelocityEngine(prop)
    engine.init
    engine
  }

  override val enabled: Boolean = true

  def VM(templatePath: String, attributes: Map[String, Any] = Map.empty, charset: String = "utf-8"): String = {
    val context = new VelocityContext
    attributes.foreach { case (key, value) => context.put(key, value) }

    val writer = new StringWriter
    plugin.engine.mergeTemplate(templatePath, charset, context, writer)
    writer.toString
  }
}

class ScalaUberspect extends UberspectImpl {

  override def getIterator(obj: java.lang.Object, i: Info): JavaIterator[_] = {
    def makeJavaIterator(iter: Iterator[_]) = new JavaIterator[AnyRef] {
      override def hasNext() = iter.hasNext
      override def next() = iter.next().asInstanceOf[AnyRef]
      override def remove() = throw new java.lang.UnsupportedOperationException("Remove not supported")
    }

    obj match {
      case i: Iterable[_] => makeJavaIterator(i.iterator)
      case i: Iterator[_] => makeJavaIterator(i)
      case _ => super.getIterator(obj, i)
    }
  }

  override def getPropertyGet(obj: java.lang.Object, identifier: String, i: Info): VelPropertyGet = {
    if (obj != null) {
      val claz = obj.getClass()

      val executor = obj match {
        case m: Map[_, _] => new ScalaMapGetExecutor(log, claz, identifier)
        case _ => new ScalaPropertyExecutor(log, introspector, claz, identifier)
      }

      if (executor.isAlive) {
        new VelGetterImpl(executor)
      } else {
        super.getPropertyGet(obj, identifier, i)
      }
    } else {
      null
    }
  }
}

object ScalaUberspect {

  private class ScalaPropertyExecutor(log: Log, introspector: Introspector, clazz: java.lang.Class[_], property: String) extends PropertyExecutor(log, introspector, clazz, property) {
    override def discover(clazz: java.lang.Class[_], property: String) = {
      setMethod(introspector.getMethod(clazz, property, Array[java.lang.Object]()))
      if (!isAlive()) {
        super.discover(clazz, property)
      }
    }
  }

  private class ScalaMapGetExecutor(val llog: Log, val clazz: java.lang.Class[_], val property: String) extends MapGetExecutor(llog, clazz, property) {
    override def isAlive = true
    override def execute(o: AnyRef) = o.asInstanceOf[Map[String, AnyRef]].getOrElse[AnyRef](property, null).asInstanceOf[java.lang.Object]
  }

}