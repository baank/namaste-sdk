package com.naden.sdk.plugin

import io.circe.{Decoder, Encoder}

trait AuthenticationService extends Service {

  def authenticate(username: String, password: String): Boolean

  def decoder: Decoder[_ <: AuthenticationService]

  def encoder: Encoder[_ <: AuthenticationService]
}
