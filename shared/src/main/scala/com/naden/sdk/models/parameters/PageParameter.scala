package com.naden.sdk.models.parameters

import boopickle.Default._

import com.naden.sdk.models.{Page, Parameter, ParameterValidator}

case class PageParameter(key: String,
                         title: String,
                         description: String,
                         group: Option[String],
                         default: Option[Page] = None,
                         required: Boolean,
                         validators: List[ParameterValidator]) extends Parameter

object PageParameter {
	implicit val pickler: Pickler[PageParameter] = generatePickler[PageParameter]
}