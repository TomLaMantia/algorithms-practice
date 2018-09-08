package runtime

import graphAPI.{Graph, dfsPaths, bfsPaths}

object Main extends App{

  var g = new Graph(7)

  g.addEdge(0, 1)
  g.addEdge(0, 2)
  g.addEdge(0, 6)
  g.addEdge(0, 5)
  g.addEdge(5, 3)
  g.addEdge(5, 4)
  g.addEdge(6, 4)
  g.addEdge(3, 4)

  val dfsObj = new dfsPaths()
  val dfsOrder = dfsObj.dfsClient(g, 0)
  print("DFS Traversal " + dfsOrder + "\n")

  val bfsObj = new bfsPaths()
  val bfsOrder = bfsObj.bfsClient(g, 0)
  println("BFS Traversal " + bfsOrder)
}