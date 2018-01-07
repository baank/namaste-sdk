package com.naden.sdk.models

import java.net.InetAddress
import boopickle.Default._

case class Connection(createdBy: User,
                      ipAddress: InetAddress,
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String])
  extends Object(createdBy)