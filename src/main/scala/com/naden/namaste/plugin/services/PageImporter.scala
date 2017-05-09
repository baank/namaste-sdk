package com.naden.namaste.plugin.services

import com.naden.namaste.models.{Page, PageType}
import com.naden.namaste.plugin.Service
import com.naden.namaste.plugin.util.ProgressObserver

trait PageImporter extends Service {

  def importPages(pages: List[Page], progressObserver: ProgressObserver)

  val requiredPageTypes: List[PageType]

}
