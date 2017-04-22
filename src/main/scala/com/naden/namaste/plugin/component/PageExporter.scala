package com.naden.namaste.plugin.component

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.util.ProgressObserver

import scala.concurrent.Future

trait PageExporter extends BaseComponent {

  def export(pages: List[Page], progressObserver: ProgressObserver): Future[Seq[(Page, Boolean, String)]]

}
