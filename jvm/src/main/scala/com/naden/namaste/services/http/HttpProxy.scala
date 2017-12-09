package com.naden.namaste.services.http

import com.naden.namaste.services.http.AuthType.AuthType

object AuthType extends Enumeration {
  type AuthType = Value
  val None, Basic, NTLM = Value
}

trait HttpProxy {

  def host(): String
  def port(): Int
  def authenticationType(): AuthType
  def domain(): String
  def username(): String
  def password(): String

}