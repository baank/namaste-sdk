package com.naden.sdk.components.widgets

import com.naden.sdk.components.Color.Color
import com.naden.sdk.components.ColorAccent.ColorAccent
import com.naden.sdk.components._
import com.naden.sdk.components.IconPosition.IconPosition
import boopickle.Default._

case class CounterStatsWidget(value: String,
            valueName: String,
            icon: String,
            iconPosition: IconPosition = IconPosition.Left,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            coloredBackground: Boolean = false,
            relatedValues: List[Value]) extends Component
