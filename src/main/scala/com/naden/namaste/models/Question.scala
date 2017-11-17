package com.naden.namaste.models

case class Question(title: String,
                    category: String,
                    body: String,
                    votes: Int)
  extends Object(createdBy)