package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class TagsParameter(key: String,
                         default: Option[String] = None,
                         limit: Option[Int] = None,
                         allowDuplicates: Boolean = true,
                         validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[List[String]](key)