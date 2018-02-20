package com.naden.sdk.plugin

import java.util.UUID

import com.naden.sdk.plugin.Theme.ThemeId

trait Theme extends Service {}

object Theme {
	type ThemeId = UUID
}