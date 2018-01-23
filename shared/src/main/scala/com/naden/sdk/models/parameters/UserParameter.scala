package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.Parameter

case class UserParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         required: Boolean) extends Parameter

object UserParameter {
	implicit val pickler: Pickler[UserParameter] = generatePickler[UserParameter]
}