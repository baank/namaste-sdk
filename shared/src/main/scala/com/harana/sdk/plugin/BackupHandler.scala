package com.harana.sdk.plugin

import java.util.UUID

trait BackupHandler extends Service {}

object BackupHandler {
	type BackupHandlerId = UUID
}