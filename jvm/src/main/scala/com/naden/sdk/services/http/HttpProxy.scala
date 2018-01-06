package com.naden.sdk.services.http

import com.naden.sdk.services.http.AuthType.AuthType

case object AuthType extends Enumeration {
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