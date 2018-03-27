package com.harana.sdk.plugin

import java.util.UUID

trait BackupType extends Service {}

object BackupType {
	type BackupType = UUID
}