package com.naden.sdk.components.widgets

import com.naden.sdk.components.{Component, Value}

case class PieChartWidget(title: String,
            subtitle: String,
            values: List[Value],
            relatedValues: List[Value]) extends Component
