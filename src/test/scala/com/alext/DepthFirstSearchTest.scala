package com.alext

import org.junit.{Test, _}
import Assert._

@Test
class DepthFirstSearchTest {
  @Test
  def searchTest_nEquals12_returnsExpected() = {
    val n = 12
    val result = DepthFirstSearch.search(n)
    assertTrue(result.isSolved)
    assertEquals(5, result.iterations)
    assertTrue(result.finalState.x == n || result.finalState.y == n)
  }
}
