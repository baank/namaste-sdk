package com.naden.sdk.plugin.services

import com.naden.sdk.models.Page
import com.naden.sdk.plugin.Service
import com.naden.sdk.plugin.util.ProgressObserver

import scala.concurrent.Future

trait PageExporter extends Service {

  def exportPages(pages: Seq[Page],
                  progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}
