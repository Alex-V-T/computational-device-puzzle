package com.alext

object TimeMeasurement {
  def printTime(actionToMeasure: Unit => Any): Unit = {
    val startTime = System.currentTimeMillis()
    actionToMeasure.apply()
    println("Time=" + (System.currentTimeMillis() - startTime) + "ms")
  }
}
