package com.naden.sdk.components.widgets

import com.naden.sdk.components.Value
import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class DonutWidget(title: String,
            subtitle: String,
            half: Boolean,
            values: List[Value],
            relatedValues: List[Value]) extends Component
