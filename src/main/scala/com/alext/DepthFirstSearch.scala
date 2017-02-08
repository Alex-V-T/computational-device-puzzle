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

  def printTime(actionToMeasure: Unit => Any): Unit = {
    val startTime = System.currentTimeMillis()
    actionToMeasure.apply()
    println("Time=" + (System.currentTimeMillis() - startTime) + "ms")
  }

  def main(args: Array[String]): Unit = {
    println("Solving series of small problems")
    printTime((Unit)=> {
      for (i <- 3 to 1000) {
        val result = search(i)
        println(i, result.iterations)
      }
    })

    println("Solving single big problem")
    printTime((Unit) => {
      val n = 1000234
      val result = search(n)
      println(n, result.iterations)
    })
  }
}