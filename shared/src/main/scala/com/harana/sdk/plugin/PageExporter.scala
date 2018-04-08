package com.harana.sdk.plugin

import java.util.UUID
import com.harana.sdk.models.Page
import com.harana.sdk.util.ProgressObserver
import scala.concurrent.Future

trait PageExporter extends Service {

  def exportPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}

object PageExporter {
  type PageExporterId = UUID
}