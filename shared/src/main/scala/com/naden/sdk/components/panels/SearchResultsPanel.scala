package com.naden.sdk.components.panels

import boopickle.Default._
import com.naden.sdk.models.Component

case class SearchResultsPanel(fixme: String) extends Component

object SearchResultsPanel {
	implicit val pickler: Pickler[SearchResultsPanel] = generatePickler[SearchResultsPanel]
}