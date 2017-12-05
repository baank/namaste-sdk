package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.Parameter

case class BooleanParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Boolean] = None)()
    extends Parameter[Boolean] {

  def validators = Seq.empty
}
