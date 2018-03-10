package com.harana.sdk.plugin

import java.util.UUID

import io.circe.{Decoder, Encoder}

trait StorageService extends Service {

	def decoder: Decoder[_ <: StorageService]

	def encoder: Encoder[_ <: StorageService]

}

object StorageService {
	type StorageServiceId = UUID
}