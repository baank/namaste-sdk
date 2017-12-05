lazy val commonSettings = Seq(
  name := "namaste-sdk",
  version := "1.0",
  scalaVersion := "2.12.4",
  organization := "com.naden.namaste",
  resolvers += Resolver.sonatypeRepo("snapshots"),
  resolvers += Resolver.sonatypeRepo("releases"),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
)

/************************************************************************************************************
 * SERVER                                                                                                   *
 ************************************************************************************************************/

lazy val server = (project in file("server")).settings(commonSettings).settings(
  scalaJSProjects := Seq(client),
  pipelineStages in Assets := Seq(scalaJSPipeline),
  pipelineStages := Seq(digest, gzip),
  compile in Compile := ((compile in Compile) dependsOn (scalaJSPipeline)).value,
  libraryDependencies ++= Seq(
    "org.osgi" % "org.osgi.core" % "6.0.0",
    "commons-codec" % "commons-codec" % "1.11",
    "javax.inject" % "javax.inject" % "1",
    "org.apache.httpcomponents" % "httpcore" % "4.4.6",
    "com.squareup.okhttp3" % "okhttp" % "3.9.0",
    "com.squareup.okhttp3" % "logging-interceptor" % "3.9.0",
    "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.1"
  )
).enablePlugins(SbtOsgi,SbtWeb).dependsOn(sharedJvm)


/************************************************************************************************************
 * CLIENT                                                                                                   *
 ************************************************************************************************************/

lazy val client = (project in file("client")).settings(commonSettings).settings(
  scalaJSUseMainModuleInitializer := true,
  libraryDependencies ++= Seq(
    "org.scala-js" %%% "scalajs-dom" % "0.9.4",
    "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
    "fr.hmil" %%% "roshttp" % "2.0.2",
    "org.scala-js" %%% "scalajs-java-time" % "0.2.3",
    "com.thoughtworks.binding" %%% "dom" % "11.0.0-M6"
  )
).enablePlugins(ScalaJSPlugin, ScalaJSWeb).dependsOn(sharedJs)

lazy val shared = (crossProject.crossType(CrossType.Pure) in file("shared")).settings(
  libraryDependencies ++= Seq(
    "org.typelevel" %%% "squants" % "1.3.0",
    "com.github.marklister" %%% "base64" % "0.2.4",
    "com.thoughtworks.binding" %%% "binding" % "11.0.0-M6",
    "com.thoughtworks.binding" %%% "futurebinding" % "11.0.0-M6"
  )
)

lazy val sharedJvm = shared.jvm
lazy val sharedJs = shared.js

onLoad in Global := (onLoad in Global).value andThen {s: State => "project server" :: s}