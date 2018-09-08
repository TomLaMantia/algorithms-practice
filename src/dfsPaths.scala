package graphAPI

import scala.collection.mutable.ArrayBuffer

class dfsPaths {

  var markedVertices: ArrayBuffer[Int] = null

  private def dfs(g: Graph, v: Int): Unit ={

    this.markedVertices += v

    for (u <- g.adj(v)){
      if (!this.markedVertices.contains(u)){
        this.markedVertices += u
        println(u)
        this.dfs(g, u)
      }
    }
  }

  def dfsClient(g: Graph, v : Int): Unit = {
    this.markedVertices = new ArrayBuffer[Int]()
    this.dfs(g, v)
  }
}