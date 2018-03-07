package com.harana.sdk.util

trait ProgressObserver {

  def updatePercentage(percentage: Int): Unit

  def updateStatus(message: String): Unit

}
