package com.naden.sdk.components.lists

import com.naden.sdk.models.Component
import io.circe.generic.JsonCodec

@JsonCodec
case class TagsList(fixme: String) extends Component
