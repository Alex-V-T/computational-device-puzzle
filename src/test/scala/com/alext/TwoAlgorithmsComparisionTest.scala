package com.alext

import org.junit.Assert.assertEquals
import org.junit.Test

class TwoAlgorithmsComparisionTest {

  @Test
  def compareTest_DepthFirstSearch_and_SingleDimensionScan() = {
    for (i <- 3 to 1000) {
      val result1 = DepthFirstSearch.search(i)
      val result2 = SingleDimensionScan.search(i)
      assertEquals(result1.isSolved, result2.isSolved)
      assertEquals(result1.iterations, result2.iterations)
      assertEquals(result1.finalState.depth(), result2.finalState.depth())
    }
  }
}
