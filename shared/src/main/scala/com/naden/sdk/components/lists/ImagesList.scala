package com.naden.sdk.components.lists

import com.naden.sdk.models.{Component, Image}
import io.circe.generic.JsonCodec

@JsonCodec
case class ImagesList(title: String,
                      icon: String,
                      images: List[Image] = List.empty,
                      columns: Int) extends Component
