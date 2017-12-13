package com.naden.namaste.components.widgets

import com.naden.namaste.components.Value

case class DonutWidget(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value])