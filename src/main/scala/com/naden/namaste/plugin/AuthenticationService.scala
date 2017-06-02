package com.naden.namaste.plugin

trait AuthenticationService extends Service {

  def authenticate(username: String, password: String): Boolean

}
