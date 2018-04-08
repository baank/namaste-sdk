package com.harana.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class SearchQuery(query: String)
