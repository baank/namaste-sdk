package com.naden.namaste.plugin.parameters

import com.naden.namaste.plugin.Parameter

case class SearchQueryParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String])()
    extends Parameter[String] {

  def validators = Seq.empty
}
