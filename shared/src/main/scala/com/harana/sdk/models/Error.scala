package com.harana.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Error(userMessage: Option[String], retriable: Boolean = false) extends Serializable