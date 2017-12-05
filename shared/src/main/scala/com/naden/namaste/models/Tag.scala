package com.naden.namaste.models

import com.naden.namaste.ui.models.Color.Color

case class Tag(createdBy: User, name: String, color: Color)
    extends Object(createdBy)
