package com.naden.sdk.plugin.services

import com.naden.sdk.plugin.Service

trait AuthenticationService extends Service {

  def authenticate(username: String, password: String): Boolean

}
