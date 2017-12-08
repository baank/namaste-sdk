package com.naden.namaste.plugin.parameters

import java.net.InetAddress

import com.naden.namaste.plugin.{Parameter, ParameterValidator}

case class IPAddressParameter(key: String,
                              title: String,
                              description: String,
                              group: Option[String],
                              default: Option[InetAddress] = None,
                              options: Seq[InetAddress] = Seq(),
                              validators: Seq[ParameterValidator] = Seq())()
    extends Parameter[InetAddress]
