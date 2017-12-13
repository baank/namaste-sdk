package com.naden.namaste.components.widgets

import com.naden.namaste.components.Color.Color
import com.naden.namaste.components.ColorAccent.ColorAccent
import com.naden.namaste.components._
import com.naden.namaste.components.IconPosition.IconPosition

case class CounterStatsWidget(value: String,
            valueName: String,
            icon: String,
            iconPosition: IconPosition = IconPosition.Left,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            coloredBackground: Boolean = false,
            relatedValues: List[Value]) extends Component