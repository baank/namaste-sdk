package com.naden.sdk.models

import java.net.InetAddress

case class Connection(createdBy: User,
                      ipAddress: InetAddress,
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String])
  extends Object(createdBy)