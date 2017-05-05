package com.naden.namaste.plugin.component

import com.naden.namaste.models.{Page, PageType}
import com.naden.namaste.plugin.util.ProgressObserver

trait PageImporter extends Component {

  def importPages(pages: List[Page], progressObserver: ProgressObserver)

  val requiredPageTypes: List[PageType]

}
