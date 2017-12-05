package com.naden.namaste.ui.models.cards

import com.naden.namaste.models.Image

case class ImageCard(image: Image,
                     showTitle: Boolean,
                     showDescription: Boolean,
                     showFileSize: Boolean,
                     showDownload: Boolean)
