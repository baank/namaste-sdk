package com.naden.sdk.plugin.parameters

import com.naden.sdk.models.User
import com.naden.sdk.plugin.Parameter

case class UserParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String])
    extends Parameter[User] {

  def validators = Seq.empty
}
