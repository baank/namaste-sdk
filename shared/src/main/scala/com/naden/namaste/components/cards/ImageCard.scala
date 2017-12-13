package com.naden.namaste.components.cards

import com.naden.namaste.components.Component
import com.naden.namaste.models.Image

case class ImageCard(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean) extends Component