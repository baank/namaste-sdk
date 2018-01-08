package com.naden.sdk.components.panels

import com.naden.sdk.components.Component
import com.naden.sdk.models.{Comment, User}

case class CommentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean) extends Component
