package com.harana.sdk.components.widgets

import com.harana.sdk.components.Value
import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class DonutWidget(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value]) extends Component
