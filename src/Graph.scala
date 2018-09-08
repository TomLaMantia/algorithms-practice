package graphAPI

import scala.collection.mutable.{LinkedList, Map}

class Graph(numVertices: Int){

  val adjList = Map[Int, LinkedList[Int]]()
  val vList = List.range[Int](0, numVertices)

  vList.foreach{i => adjList += (i -> LinkedList[Int]())}

  def addEdge(u : Int, v: Int): Unit ={
    this.adjList += (u -> adjList(u).append(LinkedList(v)))
    this.adjList += (v -> adjList(v).append(LinkedList(u)))
  }

  def adj(v : Int): LinkedList[Int] = {
      this.adjList(v)
  }

  def degree(v : Int): Int = {
    this.adjList(v).length
  }

  def maxDegree(): Int = {

    def maxDegree(u : Int, v : Int): Int = {
      if(this.adjList(u).length > this.adjList(v).length) u else v
    }

    val maxDegVertex = this.adjList.keysIterator.reduceLeft((x, y) => maxDegree(x, y))
    this.adjList(maxDegVertex).length
  }

  def avgDegree(): Float = {
    var degreeSum = 0
    this.adjList.values.foreach(neighbors => degreeSum += neighbors.length)
    degreeSum.toFloat/this.adjList.size
  }

  def size(): Int = {
    this.numVertices
  }

  override def toString: String = {
    this.adjList.toString()
  }
}