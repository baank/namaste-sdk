package com.naden.sdk.models

import boopickle.Default._

case class Connection(createdBy: User,
                      ip4Address: String,
                      ip6Address: String,
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String])
  extends Object(createdBy)

object Connection {
	implicit val pickler: Pickler[Connection] = generatePickler[Connection]
}