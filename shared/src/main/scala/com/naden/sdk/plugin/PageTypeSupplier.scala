package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.models.Page
import com.naden.sdk.plugin.PageTypeSupplier.PageTypeSupplierId
import com.naden.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

import scala.concurrent.Future

trait PageTypeSupplier extends Service {

  def getPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

  def decoder: Decoder[_ <: PageTypeSupplier]

  def encoder: Encoder[_ <: PageTypeSupplier]

}

object PageTypeSupplier {
  type PageTypeSupplierId = UUID
}
