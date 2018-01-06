package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.Parameter

case class BooleanParameter(key: String,
                            title: String,
                            description: String,
                            group: Option[String],
                            default: Option[Boolean] = None)()
    extends Parameter[Boolean] {

  def validators = Seq.empty
}
