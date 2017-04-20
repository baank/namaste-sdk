package com.naden.namaste.plugin.util

trait ProgressObserver {

  def update(progress: Option[Int], message: Option[String]): Unit

}
