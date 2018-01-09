package com.naden.sdk.plugin.parameters

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class SearchQueryParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String])()
    extends Parameter {

  def validators = List.empty
}
