package com.naden.sdk.components.widgets

import boopickle.Default._

import com.naden.sdk.models.Component

case class TimerWidget(fixme: String) extends Component

object TimerWidget {
	implicit val pickler: Pickler[TimerWidget] = generatePickler[TimerWidget]
}