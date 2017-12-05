package com.naden.namaste.plugin.util

trait ProgressObserver {

  def updatePercentage(percentage: Int): Unit

  def updateStatus(message: String): Unit

}
