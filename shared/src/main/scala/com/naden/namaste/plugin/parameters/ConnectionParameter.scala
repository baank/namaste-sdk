package com.naden.namaste.plugin.parameters

import com.naden.namaste.models.Connection
import com.naden.namaste.plugin.Parameter

case class ConnectionParameter(key: String,
                               title: String,
                               description: String,
                               group: Option[String],
                               default: Option[Connection] = None)()
    extends Parameter[Connection] {

  def validators = Seq.empty
}
