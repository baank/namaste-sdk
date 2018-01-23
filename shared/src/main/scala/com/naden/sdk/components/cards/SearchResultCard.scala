package com.naden.sdk.components.cards

import boopickle.Default._

import com.naden.sdk.models.{Component, User}

case class SearchResultCard(user: User,
            showTitle: Boolean,
            showSocial: Boolean,
            showMessaging: Boolean,
            value: String) extends Component


object SearchResultCard {
	implicit val pickler: Pickler[SearchResultCard] = generatePickler[SearchResultCard]
}