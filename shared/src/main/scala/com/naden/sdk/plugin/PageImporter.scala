package com.naden.sdk.plugin

import com.naden.sdk.models.Page
import com.naden.sdk.util.ProgressObserver

trait PageImporter extends Service {

  def importPages(pages: Seq[Page], progressObserver: ProgressObserver)

  def requiredPageTypes[PT <: PageType]: List[PT]

}
