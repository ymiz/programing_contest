import shortestPath.{ShortestPath, LabyrinthFactory, Explore}
import greedyAlgorithm.GreedyAlgorithm
import DynamicProgramming.DynamicProgramming
import PriorityQueue.Expedition
import EcologicalChain.EcologicalChain
//import NiconamaKawaii.NiconamaKawaii
import Roadblocks.Roadblocks

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
      case "-dynamic" => new DynamicProgramming().execute()
      case "-p" => new Expedition().execute()
      case "-ec" => new EcologicalChain().execute()
      //case "-nk" => new NiconamaKawaii().execute()
      case "-rb" => new Roadblocks().execute()
      case x  => println("Unknown option: '" + x + "'")
    }
    println((System.currentTimeMillis - start) + "msec") //時間計測用
  }
}