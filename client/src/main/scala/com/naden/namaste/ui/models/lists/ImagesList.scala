package com.naden.namaste.ui.models.lists

import com.naden.namaste.models.Image

case class ImagesList(title: String,
                      icon: String,
                      images: List[Image],
                      columns: Int)