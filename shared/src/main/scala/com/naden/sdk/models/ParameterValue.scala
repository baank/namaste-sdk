package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class ParameterValue(parameter: Parameter, value: String)