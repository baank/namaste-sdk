package com.naden.namaste.plugin.parameters

import com.naden.namaste.models.User
import com.naden.namaste.plugin.Parameter

case class UserParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String])
    extends Parameter[User] {

  def validators = Seq.empty
}
