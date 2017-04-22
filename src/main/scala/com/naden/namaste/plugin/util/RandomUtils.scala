package com.naden.namaste.plugin.util

import java.nio.ByteBuffer
import java.util.UUID

import org.apache.commons.codec.binary.Base64

object RandomUtils {

  def getId = {
    val uuid = UUID.randomUUID()
    val lsb = uuid.getLeastSignificantBits
    val msb = uuid.getMostSignificantBits

    val uuidBytes = ByteBuffer.allocate(16).putLong(msb).putLong(lsb).array()
    Base64.encodeBase64String(uuidBytes).substring(0, 22).replace("/", "_").replace("+", "-");
  }
}
