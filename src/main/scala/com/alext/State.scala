package com.alext

case class State(x: Int, y: Int, parent: State) {
  def OperationX(): State = {
    State(x + y, y, this)
  }

  def OperationY(): State = {
    State(x, y + x, this)
  }
}