package com.harana.sdk.components.lists

import com.harana.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class TasksList(title: String,
            icon: String) extends Component
