package com.naden.namaste.ui.models.widgets

import com.naden.namaste.ui.models.widgets.widgets.Value

case class DonutWidget(title: String,
                 subtitle: String,
                 half: Boolean,
                 values: List[Value],
                 relatedValues: List[Value])
