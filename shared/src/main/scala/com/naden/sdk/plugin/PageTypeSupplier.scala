package com.naden.sdk.plugin

import com.naden.sdk.models.Page
import com.naden.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

import scala.concurrent.Future

trait PageTypeSupplier extends Service {

  // TODO
  def getPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

  def decoder: Decoder[_ <: PageTypeSupplier]

  def encoder: Encoder[_ <: PageTypeSupplier]

}
