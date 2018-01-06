package com.naden.sdk.services.http.okhttp

import javax.inject.Singleton

import com.naden.sdk.services.http.{AuthType, HttpProxy}

@Singleton
class NoHttpProxy extends HttpProxy {

  def authenticationType() = AuthType.None
  def host = ""
  def port = 0
  def domain = ""
  def username = ""
  def password = ""
}
