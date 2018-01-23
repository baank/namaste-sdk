package com.naden.sdk.components.cards

import boopickle.Default._
import com.naden.sdk.models.{Component, Page}

case class PageCard(page: Page,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component


object PageCard {
	import com.naden.sdk.util.BoopickleCodecs._
	import com.naden.sdk.models.Page._
	implicit val pickler: Pickler[PageCard] = generatePickler[PageCard]
}