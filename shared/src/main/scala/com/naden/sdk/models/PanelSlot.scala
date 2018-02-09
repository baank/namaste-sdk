package com.naden.sdk.models

import com.naden.sdk.plugin.PanelType
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class PanelSlot(createdBy: Option[User],
                     panelType: PanelType,
                     minHeight: Int) extends Entity with Serializable {}
