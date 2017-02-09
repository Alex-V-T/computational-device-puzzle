package com.alext

object TimeMeasurement {
  def printTime(actionToMeasure: Unit => Any) = {
    val startTime = System.currentTimeMillis()
    actionToMeasure.apply()
    println(s"Time=${(System.currentTimeMillis() - startTime)}ms")
  }
}
