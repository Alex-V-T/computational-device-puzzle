package com.alext

object TimeMeasurement {
  def printTime(actionToMeasure: => Unit) {
    val startTime = System.currentTimeMillis
    actionToMeasure
    println(s"Time=${System.currentTimeMillis - startTime}ms")
  }
}
