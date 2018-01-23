package com.naden.sdk.models.parameters

import boopickle.Default._
import com.naden.sdk.models.{Parameter, ParameterValidator}
import com.naden.sdk.util.BoopickleCodecs._
import squants.Money

case class CurrencyParameter(key: String,
                             title: String,
                             description: String,
                             group: Option[String],
                             default: Option[Money] = None,
                             required: Boolean,
                             options: Seq[Money] = Seq(),
                             validators: List[ParameterValidator] = List()) extends Parameter

object CurrencyParameter {
	implicit val pickler: Pickler[CurrencyParameter] = generatePickler[CurrencyParameter]
}