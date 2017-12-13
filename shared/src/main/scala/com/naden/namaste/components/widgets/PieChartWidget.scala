package com.naden.namaste.components.widgets

import com.naden.namaste.components.{Component, Value}

case class PieChartWidget(title: String,
            subtitle: String,
            values: List[Value],
            relatedValues: List[Value]) extends Component