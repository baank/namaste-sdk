package com.naden.sdk.util

import java.nio.ByteBuffer
import java.util.UUID

import com.github.marklister.base64.Base64.Encoder

object RandomUtils {

  def id(): String = {
    val uuid = UUID.randomUUID()
    val lsb = uuid.getLeastSignificantBits
    val msb = uuid.getMostSignificantBits

    val uuidBytes = ByteBuffer.allocate(16).putLong(msb).putLong(lsb).array()
    uuidBytes.toBase64
      .substring(0, 22)
      .replace("/", "_")
      .replace("+", "-");
  }
}