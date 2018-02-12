package com.naden.sdk.models

import io.circe.generic.JsonCodec
import com.naden.sdk.util.CirceCodecs._

@JsonCodec
case class SearchResult(entities: List[Entity],
                        referredEntities: Map[String, Entity],
                        scores: List[Double])