package com.naden.sdk.plugin.parameters

import com.naden.sdk.models.Connection
import com.naden.sdk.plugin.Parameter

case class ConnectionParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Connection] = None)()
    extends Parameter {

  def validators = Seq.empty
}
