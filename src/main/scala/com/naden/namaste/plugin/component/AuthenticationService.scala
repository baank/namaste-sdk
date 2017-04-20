package com.naden.namaste.plugin.component

trait AuthenticationService extends BaseComponent {

  def authenticate(username: String, password: String): Boolean

}
