import shortestPath.{ShortestPath, LabyrinthFactory, Explore}

object main
{
  def main(args: Array[String]):Unit = {
    if (args.isEmpty) {
      println("args is empty")
      return
    }
    args.head match {
      case "-s" => new ShortestPath().execute(args.tail)
      case "-sub" => new SubsetSumProblem().execute(args.tail)
      case x  => println("Unknown option: '" + x + "'")
    }
  }
}