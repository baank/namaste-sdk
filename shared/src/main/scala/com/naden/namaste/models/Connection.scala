package com.naden.namaste.models

import java.net.InetAddress

case class Connection(ipAddress: InetAddress,
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String])