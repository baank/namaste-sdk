package com.naden.sdk.components.lists

import com.naden.sdk.components.Component
import com.naden.sdk.models.Tag

case class TasksList(title: String,
            icon: String,
            tags: List[Tag]) extends Component
