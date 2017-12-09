resolvers += "Typesafe repository" at "https://repo.typesafe.com/typesafe/releases/"
resolvers += Resolver.url("heroku-sbt-plugin-releases", url("https://dl.bintray.com/heroku/sbt-plugins/"))(Resolver.ivyStylePatterns)
resolvers += Resolver.jcenterRepo

addSbtPlugin("net.virtual-void" % "sbt-dependency-graph" % "0.9.0")
addSbtPlugin("com.typesafe.sbt" % "sbt-osgi" % "0.9.2")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.21")
addSbtPlugin("com.vmunier" % "sbt-web-scalajs" % "1.0.6")
addSbtPlugin("com.typesafe.sbt" % "sbt-gzip" % "1.0.2")
addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.1.3")
addSbtPlugin("com.typesafe.sbt" % "sbt-web" % "1.4.3")
addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.14.6")
addSbtPlugin("com.typesafe.sbt" % "sbt-js-engine" % "1.2.2")
//addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler" % "0.6.0")
//addSbtPlugin("ch.epfl.scala" % "sbt-web-scalajs-bundler" % "0.6.0")
//addSbtPlugin("com.typesafe.sbt" % "sbt-native-packager" % "1.2.0")