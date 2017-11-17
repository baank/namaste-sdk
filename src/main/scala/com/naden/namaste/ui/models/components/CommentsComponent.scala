package com.naden.namaste.ui.models.components

import com.naden.namaste.models.{Comment, User}

case class CommentsComponent(comments: List[Comment],
                             loggedInUser: User,
                             allowVoting: Boolean,
                             allowReplies: Boolean)