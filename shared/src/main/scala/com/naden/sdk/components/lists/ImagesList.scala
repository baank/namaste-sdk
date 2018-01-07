package com.naden.sdk.components.lists

import com.naden.sdk.components.Component
import com.naden.sdk.models.Image
import boopickle.Default._

case class ImagesList(title: String,
                      icon: String,
                      images: List[Image] = List.empty,
                      columns: Int) extends Component
