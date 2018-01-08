package com.naden.sdk.components.lists

import com.naden.sdk.components.Component
import com.naden.sdk.models.Comment

case class CommentsList(title: String,
            icon: String,
            comments: List[Comment] = List.empty) extends Component
