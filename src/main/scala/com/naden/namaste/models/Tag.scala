package com.naden.namaste.models

import com.naden.namaste.ui.models.Color.Color

case class Tag(name: String,
               createdBy: User,
               color: Color
  extends Object(createdBy)