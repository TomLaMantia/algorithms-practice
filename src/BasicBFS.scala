package graphAPI

import scala.collection.mutable.{Queue, ArrayBuffer}

class BasicBFS {

  var queue : Queue[Int] = null
  var marked : ArrayBuffer[Int] = null

  private def bfs(g: Graph, v : Int): Unit={
    this.queue.enqueue(v)
    this.marked += v

    while (this.queue.nonEmpty){
      val u = this.queue.dequeue()
      for (w <- g.adj(u)){
        if (!this.marked.contains(w)){
          this.marked += w
          this.queue.enqueue(w)
        }
      }
    }
  }

  def bfsClient(g: Graph, v : Int): ArrayBuffer[Int]={
    this.queue = new Queue[Int]()
    this.marked = new ArrayBuffer[Int]()
    this.bfs(g, v)
    this.marked
  }
}
