package com.naden.namaste.ui.models.panels

import com.naden.namaste.models.{Comment, User}

case class Comments(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean)