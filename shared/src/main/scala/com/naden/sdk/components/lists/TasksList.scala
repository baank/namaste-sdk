package com.naden.sdk.components.lists

import com.naden.sdk.models.{Component, Tag}
import io.circe.generic.JsonCodec

@JsonCodec
case class TasksList(title: String,
            icon: String,
            tags: List[Tag]) extends Component
