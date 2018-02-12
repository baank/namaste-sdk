package com.naden.sdk.models

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class SearchResult[T <: Entity](entities: List[T],
                                     referredEntities: Map[String, T],
                                     scores: List[Double])