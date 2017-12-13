package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Tag

case class TasksList(title: String,
            icon: String,
            tags: List[Tag]) extends Component