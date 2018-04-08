package com.harana.sdk.plugin

import java.util.UUID
import com.harana.sdk.models.{File, Image, Video}
import scala.concurrent.Future

trait StorageHandler extends Service {

  def storeFile(file: File): Future[Boolean]

	def storeImage(image: Image): Future[Boolean]

	def storeVideo(video: Video): Future[Boolean]

}

object StorageHandler {
	type StorageHandlerId = UUID
}