package com.naden.sdk.plugin

trait AuthenticationService extends Service {

  def authenticate(username: String, password: String): Boolean

}
