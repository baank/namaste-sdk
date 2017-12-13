package com.naden.namaste.components.panels

import com.naden.namaste.components.Component
import com.naden.namaste.models.{Comment, User}

case class CommentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean) extends Component