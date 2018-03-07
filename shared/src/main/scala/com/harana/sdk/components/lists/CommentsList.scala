package com.harana.sdk.components.lists

import com.harana.sdk.models.{Comment, Component}
import io.circe.generic.JsonCodec

@JsonCodec
case class CommentsList(title: String,
            icon: String,
            comments: List[Comment] = List.empty) extends Component
