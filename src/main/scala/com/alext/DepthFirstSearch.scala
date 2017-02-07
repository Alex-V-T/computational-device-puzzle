package com.alext

/**
  * Searches for an optimal solution using recursion.
  * The algorithm has exponential time complexity
  **/
object DepthFirstSearch {

  def search(n: Int): Result = {
    search(State(1, 1, null), n, 0, Result(false, 0, null))
  }

  def search(state: State, goal: Int, iteration: Int, bestResult: Result): Result = {
    if (state.x > goal || state.y > goal || (bestResult.isSolved && iteration >= bestResult.iterations))
      return bestResult

    if (state.x == goal || state.y == goal)
      return Result(true, iteration, state)

    if (iteration % 2 == 0) {
      val resultOfX = search(state.OperationX(), goal, iteration + 1, bestResult)

      search(state.OperationY(), goal, iteration + 1, resultOfX)
    } else {
      val resultOfY = search(state.OperationY(), goal, iteration + 1, bestResult)

      search(state.OperationX(), goal, iteration + 1, resultOfY)
    }
  }

  def main(args: Array[String]): Unit = {
    val startTime = System.currentTimeMillis()
    val initial = State(1, 1, null)
    for (i <- 3 to 1000) {
      val result = search(initial, i, 0, Result(false, 0, null))
      println(i, result.iterations, Math.min(result.finalState.x, result.finalState.y))
    }
    val endTime = System.currentTimeMillis()
    println("Time=" + (endTime - startTime))
  }
}