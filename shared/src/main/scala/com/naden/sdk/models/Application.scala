package com.naden.sdk.models

import com.naden.sdk.plugin.{PageType, PanelType}
import io.circe.generic.JsonCodec

@JsonCodec
case class Application(name: String,
                       version: String)