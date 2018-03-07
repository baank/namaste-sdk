package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Page
import com.harana.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

import scala.concurrent.Future

trait PageExporter extends Service {

  def exportPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

  def decoder: Decoder[_ <: PageExporter]

  def encoder: Encoder[_ <: PageExporter]

}

object PageExporter {
  type PageExporterId = UUID
}