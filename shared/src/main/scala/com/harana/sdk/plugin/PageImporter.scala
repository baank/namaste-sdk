package com.harana.sdk.plugin

import java.util.UUID
import com.harana.sdk.models.Page
import com.harana.sdk.util.ProgressObserver

trait PageImporter extends Service {

  def importPages(pages: Seq[Page], progressObserver: ProgressObserver)

  def requiredPageTypes[PT <: PageType]: List[PT]

}

object PageImporter {
  type PageImporterId = UUID
}