package com.harana.sdk.components.panels

import com.harana.sdk.models.{Comment, Component, User}
import io.circe.generic.JsonCodec

@JsonCodec
case class CommentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean) extends Component
