package com.naden.namaste.plugin.services

import com.naden.namaste.plugin.Service

trait AuthenticationService extends Service {

  def authenticate(username: String, password: String): Boolean

}
