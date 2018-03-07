package com.harana.sdk.utils

object ReflectUtils {

	def classForName[T](name: String): T = {
		Class.forName(name).asInstanceOf[T]
	}
}