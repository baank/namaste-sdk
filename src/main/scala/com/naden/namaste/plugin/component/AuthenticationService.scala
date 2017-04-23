package com.naden.namaste.plugin.component

trait AuthenticationService extends Component {

  def authenticate(username: String, password: String): Boolean

}
