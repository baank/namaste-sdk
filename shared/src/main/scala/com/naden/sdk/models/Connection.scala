package com.naden.sdk.models

case class Connection(createdBy: User,
                      ip4Address: String,
                      ip6Address: String,
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String])
  extends Object(createdBy)