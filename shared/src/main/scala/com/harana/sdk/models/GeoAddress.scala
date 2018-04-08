package com.harana.sdk.models

import io.circe.generic.JsonCodec

@JsonCodec
case class GeoAddress(unitNumber: String,
                      streetNumber: String,
                      streetName: String,
                      streetType: String,
                      postalCode: String,
                      city: String,
                      state: String,
                      country: String)
