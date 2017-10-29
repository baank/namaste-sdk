organization := "com.naden.namaste"

name := "namaste-sdk"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.4"

licenses += ("Apache-2.0", url(
  "https://www.apache.org/licenses/LICENSE-2.0.html"))

libraryDependencies ++= Seq(
  "org.osgi" % "org.osgi.core" % "5.0.0",
  "commons-codec" % "commons-codec" % "1.11",
  "joda-time" % "joda-time" % "2.9.9",
  "javax.inject" % "javax.inject" % "1",
  "org.apache.httpcomponents" % "httpcore" % "4.4.6",
  "com.squareup.okhttp3" % "okhttp" % "3.9.0",
  "com.squareup.okhttp3" % "logging-interceptor" % "3.9.0",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.9.1"
)
