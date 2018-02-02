package com.naden.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class Connection(createdBy: User,
                      ip4Address: String,
                      ip6Address: String,
                      port: Int,
                      requireSSL: Boolean,
                      username: Option[String],
                      password: Option[String])
  extends Entity