package com.naden.namaste.plugin

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.util.ProgressObserver

import scala.concurrent.Future

trait PageTypeSupplier extends Service {

  def exportPages(pages: Seq[Page],
                  progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}
