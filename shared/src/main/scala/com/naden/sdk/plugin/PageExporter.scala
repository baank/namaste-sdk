package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.models.Page
import com.naden.sdk.util.ProgressObserver
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