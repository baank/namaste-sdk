package com.naden.sdk.components.widgets

import com.naden.sdk.components.Value

case class DonutWidget(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value])
