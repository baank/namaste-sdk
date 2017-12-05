package com.naden.namaste.ui.models.widgets

import com.naden.namaste.ui.models.widgets.widgets.Value

case class PieChartWidget(title: String,
                          subtitle: String,
                          values: List[Value],
                          relatedValues: List[Value])