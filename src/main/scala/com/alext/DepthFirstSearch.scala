package com.alext

/**
  * Searches for an optimal solution using recursion.
  * The algorithm has exponential time complexity
  * It also consumes stack memory and should be run with reasonable -Xss option
  * e.g. -Xss32m for N=11138
  **/
object DepthFirstSearch {

  def search(n: Int): Result = {
    search(State(1, 1, null), n, 0, Result(false, 0, null))
  }

  def search(state: State, goal: Int, iteration: Int, bestResult: Result): Result = {
    if ((state.x > goal && state.y > goal) || (bestResult.isSolved && iteration >= bestResult.iterations))
      return bestResult

    if (state.x == goal || state.y == goal)
      return Result(true, iteration, state)

    val resultOfX = search(state.OperationX(), goal, iteration + 1, bestResult)

    search(state.OperationY(), goal, iteration + 1, resultOfX)
  }


  def main(args: Array[String]): Unit = {
    val initial = State(1, 1, null)

    println(search(initial, 1138, 0, Result(false, 0, null)))
  }
}