package com.harana.sdk.components.widgets

import com.harana.sdk.components._
import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class CounterStatsWidget(value: String,
            valueName: String,
            icon: String,
            iconPosition: IconPosition = IconPosition.Left,
            color: Color = Color.Default,
            colorAccent: ColorAccent = ColorAccent.Default,
            coloredBackground: Boolean = false,
            relatedValues: List[Value]) extends Component
