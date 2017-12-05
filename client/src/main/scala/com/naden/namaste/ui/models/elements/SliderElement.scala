package com.naden.namaste.ui.models.elements

import com.naden.namaste.ui.models.elements.Style.Style

case class SliderElement[T <: Number](name: String,
																			label: String,
																			style: Style,
																			minimum: Option[T] = Some(0),
																			maximum: Option[T] = Some(100),
																			from: Option[T] = None,
																			to: Option[T] = None,
																			step: Option[T] = None,
																			grid: Boolean = false,
																			prefix: String = "",
																			postfix: String = "",
																			maximumPostfix: String = "",
																			values: List[Any] = List(),
																			valuesSeperator: String = " - ",
																			prettify: Boolean = false,
																			prettifySeperator: String = "",
																			decorateBoth: Boolean = false)

object Style extends Enumeration {
	type Style = Value
	val SINGLE = Value("")
	val DOUBLE = Value("double")
}