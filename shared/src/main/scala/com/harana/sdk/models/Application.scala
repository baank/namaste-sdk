package com.harana.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Application(name: String, version: String)