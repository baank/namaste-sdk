package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.Comment

case class CommentsList(title: String,
                        icon: String,
                        comments: List[Comment])