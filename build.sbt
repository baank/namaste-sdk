organization := "com.naden.namaste"

name := "namaste-sdk"

version := "1.0-SNAPSHOT"

scalaVersion := "2.12.1"

licenses += ("Apache-2.0", url("https://www.apache.org/licenses/LICENSE-2.0.html"))

libraryDependencies ++= Seq(
  "org.osgi" % "org.osgi.core" % "6.0.0"
)