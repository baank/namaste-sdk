package com.naden.namaste.ui.models.widgets

import com.naden.namaste.ui.models.Color.Color
import com.naden.namaste.ui.models.widgets.widgets.IconPosition.IconPosition
import com.naden.namaste.ui.models.widgets.widgets.Value

case class CounterStatsWidget(value: String,
                              valueName: String,
                              icon: String,
                              iconPosition: IconPosition,
                              color: Color,
                              coloredBackground: Boolean,
                              relatedValues: List[Value])