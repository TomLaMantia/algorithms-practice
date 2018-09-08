package graphAPI

import scala.collection.mutable.ArrayBuffer

class dfsPaths {

  var markedVertices: ArrayBuffer[Int] = null

  private def dfs(g: Graph, v: Int): Unit ={
    this.markedVertices += v
    for (u <- g.adj(v)){
      if (!this.markedVertices.contains(u)){
        this.dfs(g, u)
      }
    }
  }

  def dfsClient(g: Graph, v : Int): ArrayBuffer[Int] ={
    this.markedVertices = new ArrayBuffer[Int]()
    this.dfs(g, v)
    this.markedVertices
  }

  def connectedComponents(g: Graph): Map[Int, ArrayBuffer[Int]] ={
    var connectedComponents = Map[Int, ArrayBuffer[Int]]()
    val verticesToCover = ArrayBuffer.range(1, g.size())

    var componentNum = 0
    while (verticesToCover.nonEmpty){
      val v = verticesToCover(0)
      val componentVertices = dfsClient(g, v)
      connectedComponents += (componentNum -> componentVertices)
      verticesToCover --= componentVertices
      componentNum += 1
    }
    connectedComponents
  }
}
