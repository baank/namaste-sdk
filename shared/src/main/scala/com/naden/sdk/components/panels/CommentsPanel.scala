package com.naden.sdk.components.panels

import boopickle.Default._

import com.naden.sdk.models.{Comment, Component, User}

case class CommentsPanel(comments: List[Comment],
                    loggedInUser: User,
                    allowVoting: Boolean,
                    allowReplies: Boolean) extends Component


object CommentsPanel {
	implicit val pickler: Pickler[CommentsPanel] = generatePickler[CommentsPanel]
}