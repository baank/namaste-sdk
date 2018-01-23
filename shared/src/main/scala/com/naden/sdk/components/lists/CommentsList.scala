package com.naden.sdk.components.lists

import boopickle.Default._

import com.naden.sdk.models.{Comment, Component}

case class CommentsList(title: String,
            icon: String,
            comments: List[Comment] = List.empty) extends Component


object CommentsList {
	implicit val pickler: Pickler[CommentsList] = generatePickler[CommentsList]
}