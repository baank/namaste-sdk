package com.naden.sdk.plugin

import io.circe.{Decoder, Encoder}

trait StorageService extends Service {

	def decoder: Decoder[_ <: StorageService]

	def encoder: Encoder[_ <: StorageService]

}
