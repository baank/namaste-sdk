package com.harana.sdk.plugin

import java.util.UUID

trait ConnectionType extends Service {}

object ConnectionType {
	type ConnectionTypeId = UUID
}