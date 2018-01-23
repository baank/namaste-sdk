package com.naden.sdk.components.panels

import boopickle.Default._

import com.naden.sdk.models.Component

case class TimerPanel(fixme: String) extends Component


object TimerPanel {
	implicit val pickler: Pickler[TimerPanel] = generatePickler[TimerPanel]
}