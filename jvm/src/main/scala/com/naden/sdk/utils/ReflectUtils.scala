package com.naden.sdk.utils

object ReflectUtils {

	def classForName[T](name: String): T = {
		Class.forName(name).asInstanceOf[T]
	}
}