import shortestPath.{ShortestPath, LabyrinthFactory, Explore}
import greedyAlgorithm.GreedyAlgorithm

object main
{
  def main(args: Array[String]):Unit = {
    if (args.isEmpty) {
      println("args is empty")
      return
    }
    val start = System.currentTimeMillis
    args.head match {
      case "-s" => new ShortestPath().execute(args.tail)
      case "-sub" => new SubsetSumProblem().execute(args.tail)
      case "-greedy" => new GreedyAlgorithm().execute()
      case x  => println("Unknown option: '" + x + "'")
    }
    println((System.currentTimeMillis - start) + "msec") //時間計測用
  }
}