package com.naden.namaste.plugin.parameters

import java.net.InetAddress
import java.util.Locale

import com.naden.namaste.plugin.{LocalizedParameter, ParameterValidator}

case class IPAddressParameter(key: String,
                           default: Option[InetAddress] = None,
                           options: Seq[InetAddress] = Seq(),
                           validators: Seq[ParameterValidator] = Seq())(implicit locale: Locale)
  extends LocalizedParameter[InetAddress](key)