package com.alext

case class State(x: Int, y: Int, parent: State) {
  def operationX(): State = {
    State(x + y, y, this)
  }

  def operationY(): State = {
    State(x, y + x, this)
  }

  def depth(): Int = {
    var counter = 0
    var current = this
    while (current.parent != null){
      current = current.parent
      counter+=1
    }

    counter
  }
}