package com.naden.sdk.models

import io.circe.{Decoder, Encoder}

import scala.collection.mutable

trait Component {

}

object Component {
	val allComponents: mutable.Map[String,Component] = mutable.Map.empty
}