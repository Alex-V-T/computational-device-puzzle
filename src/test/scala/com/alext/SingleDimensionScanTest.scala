package com.alext

import com.alext.SingleDimensionScan._
import org.junit.Assert._
import org.junit.Test

class SingleDimensionScanTest {
  @Test
  def iterateBackwardsTest_correctPair_returnsExpected() = {

    val result = iterateBackwards(11, 7, 11)
    assertTrue(result.isSolved)
  }

  @Test
  def searchTest_nEquals12_returnsExpected() = {

    val result = search(12)
    assertTrue(result.isSolved)
    assertEquals(5, result.iterations)
    assertEquals(5, result.finalState.depth())
  }
}
