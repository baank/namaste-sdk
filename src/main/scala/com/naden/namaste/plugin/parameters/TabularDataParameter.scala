package com.naden.namaste.plugin.parameters

import java.util.Locale

import com.naden.namaste.models.TabularData
import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class TabularDataParameter(key: String, validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[TabularData](key)