package com.alext

import com.alext.TimeMeasurement._

/**
  * Searches for an optimal solution using recursion.
  * The algorithm has exponential time complexity
  **/
object DepthFirstSearch {

  def search(n: Int): Result = {
    search(State(1, 1, null), n, 0, Result(false, 0, null))
  }

  private def search(state: State, goal: Int, iteration: Int, bestResult: Result): Result = {
    if (state.x > goal || state.y > goal || (bestResult.isSolved && iteration >= bestResult.iterations))
      return bestResult

    if (state.x == goal || state.y == goal)
      return Result(true, iteration, state)

    if (iteration % 2 == 0) {
      val resultOfX = search(state.operationX, goal, iteration + 1, bestResult)

      search(state.operationY, goal, iteration + 1, resultOfX)
    } else {
      val resultOfY = search(state.operationY, goal, iteration + 1, bestResult)

      search(state.operationX, goal, iteration + 1, resultOfY)
    }
  }

  def main(args: Array[String]): Unit = {
    println("Solving series of small problems")
    printTime {
      for (i <- 3 to 1000) {
        val result = search(i)
        println(i, result.iterations)
      }
    }

    println("Solving single big problem")
    printTime {
      val n = 1000234
      val result = search(n)
      println(n, result.iterations)
    }
  }
}