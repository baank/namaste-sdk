package com.naden.namaste.plugin

import com.naden.namaste.models.Page
import com.naden.namaste.plugin.util.ProgressObserver

trait PageImporter extends Service {

  def importPages(pages: Seq[Page], progressObserver: ProgressObserver)
  def requiredPageTypes: Seq[PageType]
}
