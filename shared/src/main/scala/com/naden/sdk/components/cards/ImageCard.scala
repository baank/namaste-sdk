package com.naden.sdk.components.cards

import com.naden.sdk.components.Component
import com.naden.sdk.models.Image

case class  ImageCard(image: Image,
            showTitle: Boolean,
            showDescription: Boolean,
            showFileSize: Boolean,
            showDownload: Boolean) extends Component
