package com.naden.sdk.services.http

sealed trait AuthType
object AuthType {
  case object None extends AuthType
  case object Basic extends AuthType
  case object NTLM extends AuthType
}

trait HttpProxy {

  def host(): String
  def port(): Int
  def authenticationType(): AuthType
  def domain(): String
  def username(): String
  def password(): String

}