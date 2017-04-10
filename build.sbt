import com.typesafe.config.ConfigFactory
val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

name := """Namaste"""

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.1"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "io.dropwizard.metrics" % "metrics-core" % "3.2.2",
  "io.dropwizard.metrics" % "metrics-healthchecks" % "3.2.2",
  "io.dropwizard.metrics" % "metrics-json" % "3.2.2",
  "io.dropwizard.metrics" % "metrics-jvm" % "3.2.2",
  "io.dropwizard.metrics" % "metrics-logback" % "3.2.2",
  "nl.grons" %% "metrics-scala" % "3.5.6",
  "com.fasterxml.jackson.module" %% "jackson-module-scala" % "2.8.7",
  "com.vladsch.flexmark" % "flexmark-all" % "0.18.5",
  "com.h2database" % "h2" % "1.4.194",
  "org.osgi" % "org.osgi.core" % "6.0.0" % "provided",
  "org.osgi" % "org.osgi.compendium" % "5.0.0",
  "org.apache.felix" % "org.apache.felix.framework" % "5.6.2",
  "org.apache.felix" % "org.apache.felix.fileinstall" % "3.5.8" ,
  "org.apache.felix" % "org.apache.felix.configadmin" % "1.8.14" ,
  "org.apache.felix" % "org.apache.felix.gogo.runtime" % "1.0.4" ,
  "org.apache.felix" % "org.apache.felix.gogo.command" % "1.0.2" ,
  "org.apache.felix" % "org.apache.felix.gogo.shell" % "1.0.0" ,
  "org.apache.felix" % "org.apache.felix.webconsole" % "4.3.0" ,
  "org.apache.felix" % "org.apache.felix.http.bundle" % "3.0.0" ,
  "org.apache.felix" % "org.apache.felix.shell" % "1.4.3",
  "org.apache.felix" % "org.apache.felix.shell.remote" % "1.2.0",
  "org.apache.felix" % "org.apache.felix.bundlerepository" % "2.0.8",
  "org.apache.felix" % "org.apache.felix.http.api" % "3.0.0",
  "commons-fileupload" % "commons-fileupload" % "1.3.2",
  "commons-io" % "commons-io" % "2.5",
  "de.twentyeleven.skysail" % "org.json-osgi" % "20080701"
)

cleanKeepFiles ++= Seq("resolution-cache", "streams").map(target.value / _)

val copyOSGIBundlesTask = taskKey[Unit]("Copy OSGI system bundles task")
val Stage = config("copyOSGIBundlesTask")
val systemBundlesDir = (if (conf.hasPath("application.bundles.dir")) conf.getString("application.bundles.dir") else "conf/bundles")

lazy val root = (project in file(".")).enablePlugins(PlayScala).configs(Stage).settings( inConfig(Stage)(Classpaths.ivyBaseSettings): _* )

copyOSGIBundlesTask := {
  (update in Stage).value.allFiles.foreach { f =>
    (libraryDependencies in Stage).value.foreach {
      lib =>
        (dependencyClasspath in Compile).value.foreach {
          dep =>
            if(dep.metadata.get(moduleID.key).get.equals(lib)){
              IO.copyFile(dep.data, baseDirectory.value / systemBundlesDir / dep.data.getName)
            }
        }
    }
  }
}

(test in Test) <<= (test in Test) dependsOn (copyOSGIBundlesTask)
