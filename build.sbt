
lazy val commonSettings = Seq(
  name := "namaste-sdk",
  version := "1.0",
  scalaVersion := "2.12.4",
  organization := "com.naden.namaste",
  resolvers += Resolver.sonatypeRepo("releases"),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.0" cross CrossVersion.full)
)

lazy val root = project.in(file(".")).
  aggregate(namasteSdkJVM, namasteSdkJS).
  settings(commonSettings).
  settings(
    publish := {},
    publishLocal := {}
  ).
  enablePlugins(SbtOsgi)

lazy val namasteSdk = crossProject.in(file(".")).
  settings(commonSettings).
  settings(
    libraryDependencies ++= Seq(
      "org.typelevel" %%% "squants" % "1.3.0",
      "com.github.marklister" %%% "base64" % "0.2.4",
      "com.thoughtworks.binding" %%% "binding" % "11.0.0-M6",
      "com.thoughtworks.binding" %%% "futurebinding" % "11.0.0-M6"
    )
  ).
  jvmSettings(
    libraryDependencies ++= Seq(
      "org.osgi" % "org.osgi.core" % "6.0.0",
      "commons-codec" % "commons-codec" % "1.11",
      "javax.inject" % "javax.inject" % "1",
      "org.apache.httpcomponents" % "httpcore" % "4.4.6",
      "com.squareup.okhttp3" % "okhttp" % "3.9.0",
      "com.squareup.okhttp3" % "logging-interceptor" % "3.9.0",
      "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.1"
    )
  ).
  jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js" %%% "scalajs-dom" % "0.9.4",
      "org.scala-lang.modules" %% "scala-xml" % "1.0.6",
      "fr.hmil" %%% "roshttp" % "2.0.2",
      "org.scala-js" %%% "scalajs-java-time" % "0.2.3",
      "com.thoughtworks.binding" %%% "dom" % "11.0.0-M6"
    )
  )

lazy val namasteSdkJVM = namasteSdk.jvm
lazy val namasteSdkJS = namasteSdk.js