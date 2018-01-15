package com.naden.sdk.components.panels

import com.naden.sdk.models.{Comment, Component, User}
import io.circe.generic.JsonCodec

@JsonCodec
case class CommentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean) extends Component
