package com.alext

import com.alext.TimeMeasurement._

/**
  * Searches for optimal solution traversing second registry and iterating backwards
  * Complexity is O(N^2)
  **/
object SingleDimensionScan {
  def search(n: Int): Result = {
    var bestResult = Result(false, n, null)

    for (i <- n / 2 until n) {
      val result = iterateBackwards(n, i, bestResult.iterations)
      if (result.isSolved && result.iterations < bestResult.iterations)
        bestResult = result
    }

    for (i <- n / 2 - 1 to 1 by -1) {
      val result = iterateBackwards(n, i, bestResult.iterations)
      if (result.isSolved && result.iterations < bestResult.iterations)
        bestResult = result
    }

    buildResult(bestResult)
  }

  def iterateBackwards(initialX: Int, initialY: Int, iterationsCap: Int): Result = {
    var j = 0
    var currentX = initialX
    var currentY = initialY

    while (currentX > 0 && currentY > 0 && j < iterationsCap && !(currentX == 1 && currentY == 1)) {
      if (currentX > currentY) {
        currentX = currentX - currentY
      } else {
        currentY = currentY - currentX
      }
      j += 1
    }
    if (currentX == 1 && currentY == 1) {
      return Result(true, j, State(initialX, initialY, null))
    }

    Result(false, j, null)
  }

  def buildResult(partialResult: Result): Result = {
    Result(partialResult.isSolved, partialResult.iterations,
      buildState(partialResult.finalState.x, partialResult.finalState.y))
  }

  def buildState(currentX: Int, currentY: Int): State = {
    if (currentX == 1 && currentY == 1) {
      State(1, 1, null)
    } else {
      if (currentX > currentY) {
        State(currentX, currentY, buildState(currentX - currentY, currentY))
      } else {
        State(currentX, currentY, buildState(currentX, currentY - currentX))
      }
    }
  }

  def main(args: Array[String]): Unit = {
    println("Solving series of small problems")
    printTime((Unit) => {
      for (i <- 3 to 1000) {
        val result = search(i)
        println(i, result.iterations)
      }
    })

    println("Solving single big problem")
    printTime((Unit) => {
      val n = 100023400
      val result = search(n)
      println(n, result.iterations)
    })
  }
}
