package com.naden.namaste.ui.models.components

import java.time.LocalDateTime

import com.naden.namaste.models.Event
import com.naden.namaste.ui.models.components.Action.Action
import com.naden.namaste.ui.models.components.View.View

case class CalendarComponent(events: List[Event],
                             eventColors: Map[Event, String],
                             leftActions: List[Action],
                             centerActions: List[Action],
                             rightActions: List[Action],
                             defaultView: View,
                             defaultTime: LocalDateTime,
                             viewLabels: Map[View, String],
                             navigationLinks: Boolean,
                             editable: Boolean,
                             businessHours: Boolean,
                             eventLimit: Boolean)


object View extends Enumeration {
  type View = Value
  val BASIC_DAY = Value("basicDay")
  val BASIC_WEEK = Value("basicWeek")
  val AGENDA_DAY = Value("agendaDay")
  val AGENDA_WEEK = Value("agendaWeek")
  val LIST_DAY = Value("listDay")
  val LIST_WEEK = Value("listWeek")
  val LIST_MONTH = Value("listMonth")
  val LIST_YEAR = Value("listYear")
  val MONTH = Value("month")
}

object Action extends Enumeration {
  type Action = Value
  val BASIC_DAY_VIEW = View.BASIC_DAY
  val BASIC_WEEK_VIEW = View.BASIC_WEEK
  val AGENDA_DAY_VIEW = View.AGENDA_DAY
  val AGENDA_WEEK_VIEW = View.AGENDA_WEEK
  val LIST_DAY_VIEW = View.LIST_DAY
  val LIST_WEEK_VIEW = View.LIST_WEEK
  val LIST_MONTH_VIEW = View.LIST_MONTH
  val LIST_YEAR_VIEW = View.LIST_YEAR
  val MONTH_VIEW = View.MONTH
  val TITLE = Value("title")
  val TODAY = Value("today")
  val PREVIOUS = VALUE("prev")
  val NEXT = VALUE("next")
}