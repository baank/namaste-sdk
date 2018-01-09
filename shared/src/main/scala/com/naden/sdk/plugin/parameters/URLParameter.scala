package com.naden.sdk.plugin.parameters

import java.net.URL

import com.naden.sdk.plugin.{Parameter, ParameterValidator}

case class URLParameter(key: String,
						                         title: String,
						                         description: String,
						                         group: Option[String],
						                         default: Option[URL] = None,
						                         validators: List[ParameterValidator] = List())()
	extends Parameter
