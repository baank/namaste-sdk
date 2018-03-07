import sbtcrossproject.{crossProject, CrossType}

lazy val commonSettings = Seq(
  name := "harana-sdk",
  version := "1.0",
  scalaVersion := "2.12.4",
  organization := "com.harana",
  resolvers += Resolver.sonatypeRepo("releases"),
  updateOptions := updateOptions.value.withCachedResolution(true),
  //addCompilerPlugin("io.tryp" % "splain" % "0.2.7" cross CrossVersion.patch),
  addCompilerPlugin("org.scalamacros" % "paradise" % "2.1.1" cross CrossVersion.full),
  scalacOptions ++= Seq("-deprecation"),
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

lazy val harana = crossProject(JSPlatform, JVMPlatform).in(file(".")).
  settings(commonSettings).
  settings(
    libraryDependencies ++= Seq(
      "org.typelevel"           %%% "squants"               % "1.3.0",
      "com.github.marklister"   %%% "base64"                % "0.2.4",
      "io.circe"                %%% "circe-core"            % "0.9.1",
      "io.circe"                %%% "circe-generic"         % "0.9.1",
      "io.circe"                %%% "circe-generic-extras"  % "0.9.1",
      "io.circe"                %%% "circe-parser"          % "0.9.1",
      "com.beachape"            %%% "enumeratum-circe"      % "1.5.15"
    )
  ).
  jvmSettings(
    commonSettings,
    libraryDependencies ++= Seq(
      "org.osgi" % "org.osgi.core" % "6.0.0",
      "commons-codec" % "commons-codec" % "1.11",
      "javax.inject" % "javax.inject" % "1",
      "org.scala-js" %% "scalajs-stubs" % "0.6.22" % "provided"
    )
  ).
  jsSettings(
    libraryDependencies ++= Seq(
      "org.scala-js"            %%% "scalajs-java-time"     % "0.2.3"
    )
  )

lazy val jvm = harana.jvm
lazy val js = harana.js
