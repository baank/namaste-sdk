package com.harana.sdk.plugin

import java.util.UUID

trait AuthenticationHandler extends Service {

  def authenticate(username: String, password: String): Boolean

}

object AuthenticationHandler {
  type AuthenticationHandlerId = UUID
}