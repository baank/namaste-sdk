package com.naden.namaste.services.http

import com.naden.namaste.services.http.AuthType.AuthType

object AuthType extends Enumeration {
  type AuthType = Value
  val None, Basic, NTLM = Value
}

case class HttpProxy(host: String,
                     port: Int,
                     authenticationType: AuthType,
                     domain: String,
                     username: String,
                     password: String)
