package com.naden.namaste.plugin.services

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.Service
import com.naden.namaste.plugin.util.ProgressObserver

import scala.concurrent.Future

trait PageTypeSupplier extends Service {

  // TODO
  def getPages(pages: Seq[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}
