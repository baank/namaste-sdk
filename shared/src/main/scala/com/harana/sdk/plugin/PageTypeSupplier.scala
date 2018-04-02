package com.harana.sdk.plugin

import java.util.UUID

import com.harana.sdk.models.Page
import com.harana.sdk.util.ProgressObserver
import io.circe.{Decoder, Encoder}

import scala.concurrent.Future

trait PageTypeSupplier extends Service {

  def getPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}

object PageTypeSupplier {
  type PageTypeSupplierId = UUID
}
