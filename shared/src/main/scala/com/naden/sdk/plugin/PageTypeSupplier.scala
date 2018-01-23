package com.naden.sdk.plugin

import com.naden.sdk.models.Page
import com.naden.sdk.util.ProgressObserver

import scala.concurrent.Future

trait PageTypeSupplier extends Service {

  def getPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}
