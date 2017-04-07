package services.plugin

import java.io.File
import java.nio.file.{Files, Paths}
import java.util
import javax.inject.{Inject, Singleton}

import org.apache.felix.framework.Felix
import org.osgi.framework.{Bundle, Constants}
import play.api.{Application, Logger}
import utils.TcpPortFinder

import scala.collection.mutable.ListBuffer

@Singleton
class ContextHolder @Inject() (app: Application) {

  val scalaVersion = scala.util.Properties.versionNumberString
  val systemBundleDir = new java.io.File(app.configuration.getOptional[String]("application.bundles.dir").getOrElse("conf/bundles"))
  val pluginsDir = new java.io.File(app.configuration.getOptional[String]("application.plugins.dir").getOrElse("conf/plugins"))
  val osgiCacheDir = new java.io.File(app.configuration.getOptional[String]("application.osgi.cache.dir").getOrElse("conf/felix-cache"))
  val webConsoleUser = new java.io.File(app.configuration.getOptional[String]("application.osgi.webconsole.user").getOrElse("admin"))
  val webConsolePassword = new java.io.File(app.configuration.getOptional[String]("application.osgi.webconsole.password").getOrElse("admin"))
  val packages = app.configuration.getOptional[String]("application.osgi.export.packages").getOrElse("")

  val systemPackages = packages + "scala;version="+scalaVersion+",scala.annotation;version="+scalaVersion+",scala.collection;version="+scalaVersion+",scala.collection.generic;version="+scalaVersion+",scala.collection.immutable;version="+scalaVersion+",scala.collection.mutable;version="+scalaVersion+",scala.collection.parallel;version="+scalaVersion+",scala.collection.parallel.immutable;version="+scalaVersion+",scala.io;version="+scalaVersion+",scala.math;version="+scalaVersion+",scala.reflect;version="+scalaVersion+",scala.runtime;version="+scalaVersion+",scala.util;version="+scalaVersion+",scala.annotation;version="+scalaVersion+",org.osgi.service,services,utils,com.fasterxml.jackson,play,io.gatling.jsonpath"
  lazy val BundleContext = {
    var bundleContext : Option[()=>org.osgi.framework.BundleContext] = None
    //Install required bundles for embedded felix instance
    def installSystemBundles() = {
      val systemBundles = new ListBuffer[Bundle]()
      if(systemBundleDir.exists()) {
        systemBundleDir.listFiles.filter(_.isFile).filter(_.getName.endsWith("jar")).foreach {
          bundleJar =>
            Logger.info("Installing System Bundle: " + bundleJar.getAbsolutePath)
            systemBundles += bundleContext.get().installBundle("file:" + bundleJar.getAbsolutePath)
        }
        for (bundle <- systemBundles) {
          bundle.start()
        }
      }
    }
    //Initialize the felix instance and the OSGI bundle context
    def initBundleContext():org.osgi.framework.BundleContext  = {
      if(!bundleContext.isDefined) {
        val shellPort = TcpPortFinder.findAvailablePort
        val osgiHttpPort = TcpPortFinder.findAvailablePort
        val props = new util.HashMap[String,String]
        //Add system packages to felix and enable cleanup of framework storage
        props.put(Constants.FRAMEWORK_SYSTEMPACKAGES_EXTRA,systemPackages)
        props.put(Constants.FRAMEWORK_STORAGE_CLEAN,"true")
        //OSGI properties - enable cleanup of felix-cache on init
        props.put(Constants.FRAMEWORK_STORAGE,osgiCacheDir.toString)
        props.put("org.osgi.framework.storage.clean", "onFirstInit")
        //Felix properties - enable shutdown hook and urlhandlers for webconsole
        props.put("felix.shutdown.hook", "true")
        props.put("felix.service.urlhandlers", "true")
        //File-install bundle properties - enables file-install (watches for changes to the pluginsDir folder and installs/starts/stops/updates any bundles found)
        props.put("felix.fileinstall.dir", pluginsDir.getAbsolutePath)
        props.put("felix.fileinstall.noInitialDelay", "true")
        props.put("felix.fileinstall.log.level", "4")
        //Web console properties - enables web console bundle
        props.put("felix.webconsole.username", webConsoleUser.toString)
        props.put("felix.webconsole.password", webConsolePassword.toString)
        props.put("org.apache.felix.http.jettyEnabled", "true")
        //OSGI remote shell properties - enables felix remote shell
        props.put("osgi.shell.telnet", "on")
        props.put("org.osgi.service.http.port",osgiHttpPort.toString)
        props.put("osgi.shell.telnet.port", shellPort.toString)
        //Felix gogo shell properties - disable the interactive shell, enable only telnet access
        props.put("gosh.args", "--nointeractive")
        Logger.info("Initializing OSGI bundle context with properties: " + props )
        //Initialize and start the felix instance
        val felix = new Felix(props)
        felix.start()
        bundleContext = Some(felix.getBundleContext _)
        //Install the required system bundles
        installSystemBundles()
        felix.init()
      }
       bundleContext.get()
    }
    initBundleContext()
  }
}

@Singleton
class OSGIService @Inject() (contextHolder: ContextHolder) extends PluginService {

    contextHolder.BundleContext

    def installPlugin(bundleLocation: String)  = {
      Logger.info("Installing plugin: " + bundleLocation)
      val installedBundle = contextHolder.BundleContext.installBundle(bundleLocation)
      installedBundle.start()
    }

    def uninstallPlugin(bundleLocation: String) = {
      contextHolder.BundleContext.getBundles.filter(_.getLocation.equals(bundleLocation)).foreach {
         bundle =>
           Logger.info("Uninstalling plugin: " + bundleLocation)
           bundle.uninstall()
      }
    }

    def removePlugin(pluginName: String) = {
      contextHolder.pluginsDir.listFiles.filter(_.isFile).filter(_.getName.equals(pluginName)).foreach {
        file =>
          if(file.exists()) {
            Logger.info("Removing plugin: " + file.getName)
            file.delete()
          }
      }
    }

    def copyPlugin(filePath: String) = {
      val originFile = new File(filePath)
      Files.copy(Paths.get(filePath), Paths.get(contextHolder.pluginsDir+"/"+originFile.getName))
    }

    def findService[T <: AnyRef](clazz : Class[T], filter: String) : Option[T] = {
      val services = findServices(clazz, filter)
      if(!services.isEmpty){
        services.head
      }else{
        None
      }
    }

    def findServices[T <: AnyRef](clazz : Class[T], filter: String) : ListBuffer[Option[T]] = {
      Logger.info("Retrieving services for class: " + clazz.getName + " and filter: " + filter)
      val ctx = contextHolder.BundleContext
      val services = new ListBuffer[Option[T]]()
      var ctxFilter: String = null
      var clazzName: String = null
      if(!filter.isEmpty){
        ctxFilter = ctx.createFilter(filter).toString
      }
      if(clazz!=null){
        clazzName=clazz.getName
      }
      val serviceRefs = ctx.getServiceReferences(clazzName, ctxFilter)
      if(serviceRefs != null) {
        for(service <- serviceRefs) {
          services += Some(ctx.getService(service).asInstanceOf[T])
        }
      }
      services
    }

    def findService[T <: AnyRef](clazz : Class[T]) = {
      utils.osgi.toRichBundleContext(contextHolder.BundleContext).findService(clazz)
    }

    def findServices[T <: AnyRef](clazz : Class[T]) = {
      utils.osgi.toRichBundleContext(contextHolder.BundleContext).findServices(clazz)
    }

    def createService[T <: AnyRef](service : T, properties: Map[String, Any]) = {
      utils.osgi.toRichBundleContext(contextHolder.BundleContext).createService(service, properties)
    }
}
