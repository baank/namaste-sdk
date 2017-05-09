package com.naden.namaste.plugin.services

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.Service
import com.naden.namaste.plugin.util.ProgressObserver

import scala.concurrent.Future

trait PageExporter extends Service {

  def exportPages(pages: List[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}
