package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Comment

case class CommentsList(title: String,
            icon: String,
            comments: List[Comment]) extends Component