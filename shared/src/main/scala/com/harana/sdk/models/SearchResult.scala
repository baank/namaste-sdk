package com.harana.sdk.models

import io.circe.generic.JsonCodec
import com.harana.sdk.util.CirceCodecs._

@JsonCodec
case class SearchResult[T <: Entity](entities: List[T],
                                     referredEntities: Map[String, T],
                                     scores: List[Double])