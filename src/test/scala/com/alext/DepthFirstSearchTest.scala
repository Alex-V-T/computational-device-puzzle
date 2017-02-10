package com.alext

import com.alext.DepthFirstSearch._
import org.junit.Assert._
import org.junit.{Test, _}

class DepthFirstSearchTest {
  @Test
  def searchTest_nEquals12_returnsExpected() = {
    val n = 12
    val result = search(n)
    assertTrue(result.isSolved)
    assertEquals(5, result.iterations)
    assertTrue(result.finalState.x == n || result.finalState.y == n)
  }
}
