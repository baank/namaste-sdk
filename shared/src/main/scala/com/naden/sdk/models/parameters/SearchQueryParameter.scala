package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.Parameter

case class SearchQueryParameter(key: String,
                                title: String,
                                description: String,
                                group: Option[String],
                                required: Boolean) extends Parameter

object SearchQueryParameter {
	implicit val pickler: Pickler[SearchQueryParameter] = generatePickler[SearchQueryParameter]
}