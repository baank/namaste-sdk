package com.harana.sdk.plugin

import java.util.UUID

trait Connection extends Service {}

object Connection {
	type ConnectionId = UUID
}