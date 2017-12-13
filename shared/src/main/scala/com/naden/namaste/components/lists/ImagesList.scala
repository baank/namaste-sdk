package com.naden.namaste.components.lists

import com.naden.namaste.components.Component
import com.naden.namaste.models.Image

case class ImagesList(title: String,
            icon: String,
            images: List[Image],
            columns: Int) extends Component