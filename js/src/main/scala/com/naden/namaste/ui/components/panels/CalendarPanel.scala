package com.naden.namaste.ui.components.panels

import java.time.LocalDateTime

import com.naden.namaste.models.Event
import com.naden.namaste.ui.components.panels.CalendarPanel.CalendarAction.CalendarAction
import com.naden.namaste.ui.components.panels.CalendarPanel.CalendarView.CalendarView
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.html.Div

object CalendarPanel {

  @dom
  def calendarPanel(events: List[Event],
                    eventColors: Map[Event, String],
                    leftActions: List[CalendarAction],
                    centerActions: List[CalendarAction],
                    rightActions: List[CalendarAction],
                    defaultView: CalendarView,
                    defaultTime: LocalDateTime,
                    viewLabels: Map[CalendarView, String],
                    navigationLinks: Boolean,
                    editable: Boolean,
                    businessHours: Boolean,
                    eventLimit: Boolean): Binding[Div] = {
    <div></div>
  }

  object CalendarView extends Enumeration {
    type CalendarView = Value
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

  object CalendarAction extends Enumeration {
    type CalendarAction = Value
    val BASIC_DAY_VIEW = CalendarView.BASIC_DAY
    val BASIC_WEEK_VIEW = CalendarView.BASIC_WEEK
    val AGENDA_DAY_VIEW = CalendarView.AGENDA_DAY
    val AGENDA_WEEK_VIEW = CalendarView.AGENDA_WEEK
    val LIST_DAY_VIEW = CalendarView.LIST_DAY
    val LIST_WEEK_VIEW = CalendarView.LIST_WEEK
    val LIST_MONTH_VIEW = CalendarView.LIST_MONTH
    val LIST_YEAR_VIEW = CalendarView.LIST_YEAR
    val MONTH_VIEW = CalendarView.MONTH
    val TITLE = Value("title")
    val TODAY = Value("today")
    val PREVIOUS = Value("prev")
    val NEXT = Value("next")
  }
}