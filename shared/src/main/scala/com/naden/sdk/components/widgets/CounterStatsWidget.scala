package com.naden.sdk.components.widgets

import com.naden.sdk.components._

case class CounterStatsWidget(value: String,
            valueName: String,
            icon: String,
            iconPosition: IconPosition = IconPosition.Left,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            coloredBackground: Boolean = false,
            relatedValues: List[Value]) extends Component
