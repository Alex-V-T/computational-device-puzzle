package com.alext

import org.junit.Assert._
import org.junit.{Test, _}

class SingleDimensionScanTest {
  @Test
  def iterateBackwardsTest_correctPair_returnsExpected() = {

    val result = SingleDimensionScan.iterateBackwards(11, 7, 11)
    assertTrue(result.isSolved)
  }

  @Test
  def searchTest_nEquals12_returnsExpected() = {

    val result = SingleDimensionScan.search(12)
    assertTrue(result.isSolved)
    assertEquals(5, result.iterations)
    assertEquals(5, result.finalState.depth())
  }
}
