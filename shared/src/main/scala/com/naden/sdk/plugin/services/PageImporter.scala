package com.naden.sdk.plugin.services

import com.naden.sdk.models.Page
import com.naden.sdk.plugin.Service
import com.naden.sdk.plugin.util.ProgressObserver

trait PageImporter extends Service {

  def importPages(pages: Seq[Page], progressObserver: ProgressObserver)
  def requiredPageTypes: Seq[PageType]
}
