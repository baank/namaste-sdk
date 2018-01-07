
lazy val commonSettings = Seq(
  name := "naden-sdk",
  version := "1.0",
  scalaVersion := "2.12.4",
  organization := "com.naden",
  resolvers += Resolver.sonatypeRepo("releases"),
  updateOptions := updateOptions.value.withCachedResolution(true),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
  scalacOptions ++= Seq(
    "-deprecation"
  ),
  javacOptions ++= Seq(
  )
)

lazy val root = project.in(file(".")).
  aggregate(jvm, js).
  settings(commonSettings).
  settings(
    publish := {},
    publishLocal := {}
  ).
  enablePlugins(SbtOsgi)

lazy val naden = crossProject.in(file(".")).
  settings(commonSettings).
  settings(
    libraryDependencies ++= Seq(
      "org.typelevel"             %%% "squants"               % "1.3.0",
      "com.github.marklister"     %%% "base64"                % "0.2.4",
      "io.suzaku"                 %%% "boopickle"             % "1.2.6"
    )
  ).
  jvmSettings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.osgi" % "org.osgi.core" % "6.0.0",
      "commons-codec" % "commons-codec" % "1.11",
      "javax.inject" % "javax.inject" % "1",
      "org.apache.httpcomponents" % "httpcore" % "4.4.8",
      "com.squareup.okhttp3" % "okhttp" % "3.9.1",
      "com.squareup.okhttp3" % "logging-interceptor" % "3.9.1",
      "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.2"
    )
  ).
  jsSettings(
    libraryDependencies ++= Seq()
  )

lazy val jvm = naden.jvm
lazy val js = naden.js
