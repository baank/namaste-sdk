package com.naden.sdk.models

import com.naden.sdk.plugin.PanelType
import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class Panel(createdBy: User,
                 title: String,
                 description: String,
                 panelType: PanelType,
                 parameterValues: List[(Parameter, String)])
    extends Entity {}