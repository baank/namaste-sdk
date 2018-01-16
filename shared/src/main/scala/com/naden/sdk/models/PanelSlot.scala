package com.naden.sdk.models

import com.naden.sdk.plugin.PanelType
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class PanelSlot(createdBy: User,
                     panelType: PanelType,
                     minHeight: Int) extends Object(createdBy) {}
