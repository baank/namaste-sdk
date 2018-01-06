package com.naden.sdk.plugin.util

trait ProgressObserver {

  def updatePercentage(percentage: Int): Unit

  def updateStatus(message: String): Unit

}
