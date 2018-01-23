package com.naden.sdk.models

import boopickle.Default._
import com.naden.sdk.plugin.{PageType, PanelType}

case class Application(name: String,
                       version: String)

object Application {
	implicit val pickler: Pickler[Application] = generatePickler[Application]
}