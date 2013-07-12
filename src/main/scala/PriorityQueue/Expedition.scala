package PriorityQueue

import collection.mutable
import collection.mutable.MutableList

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/06/14
 * Time: 8:01
 * To change this template use File | Settings | File Templates.
 */
class Expedition {
  val gasStationNum: Int = 100 // N
  val distance: Int = 5000 // L
  val initialGas: Int = 100 // P
  val gasStationDistanceList: List[Int] = List(1, 76, 138, 155, 243, 260, 335, 435, 498, 536, 564, 594, 602, 636, 695, 744, 750, 838, 869, 966, 1053, 1072, 1108, 1184, 1225, 1271, 1342, 1376, 1391, 1432, 1487, 1541, 1635, 1697, 1755, 1794, 1799, 1812, 1822, 1836, 1860, 1951, 1964, 1997, 2015, 2056, 2057, 2123, 2132, 2187, 2213, 2284, 2373, 2412, 2451, 2530, 2610, 2657, 2734, 2760, 2856, 2912, 3003, 3050, 3070, 3098, 3148, 3223, 3302, 3400, 3432, 3510, 3586, 3604, 3607, 3622, 3713, 3754, 3807, 3848, 3920, 4012, 4085, 4091, 4159, 4227, 4260, 4354, 4360, 4388, 4406, 4426, 4441, 4535, 4623, 4687, 4760, 4824, 4854, 4880) // A
  val gasQuantityList: List[Int] = List(70, 31, 45, 45, 48, 61, 87, 52, 89, 26, 2, 51, 24, 91, 2, 11, 46, 82, 78, 26, 85, 81, 100, 64, 70, 19, 71, 8, 52, 87, 36, 73, 38, 63, 55, 87, 52, 91, 25, 58, 10, 47, 9, 21, 81, 27, 56, 58, 70, 74, 42, 85, 58, 85, 99, 79, 4, 85, 68, 71, 11, 60, 40, 53, 49, 4, 37, 73, 24, 28, 95, 60, 67, 81, 31, 9, 39, 81, 91, 74, 39, 42, 81, 73, 100, 37, 16, 53, 98, 17, 52, 29, 75, 20, 67, 62, 26, 11, 29, 71) // B


//  val gasStationNum: Int = 4 // N
//  val cost: Int = 25 // L
//  val initialGas: Int = 10 // P
//  val gasStationDistanceList: List[Int] = List(10, 14, 20, 21) // A
//  val gasQuantityList: List[Int] = List(10, 5, 2, 4) // B

  val gasStationList: List[(Int, Int)] = gasStationDistanceList.zip(gasQuantityList)
  var usedGasStationList: MutableList[(Int, Int)] = MutableList()


  def execute(): Unit = {
    val pq: mutable.PriorityQueue[(Int, Int)] = new mutable.PriorityQueue[(Int, Int)]()(Ordering.by(_._2))
    //すべてのGSに止まってみる
    var track:Track = explore((0,0), gasStationList(0), new Track(0, initialGas), pq)
    for (i <- 1 until gasStationList.length){
      if(i!=gasStationNum-1){
        track = explore(gasStationList(i), gasStationList(i+1), track, pq)
      }else{
        track = explore(gasStationList(i), (distance, 0), track, pq)
      }
    }
    usedGasStationList.foreach(p => println(p))
    println(usedGasStationList.length)
  }


  def explore(presentStation: (Int, Int), nextStation: (Int, Int), track: Track, pq:mutable.PriorityQueue[(Int, Int)]): Track = {
    //給油しなくても次のGSまで行けそうであれば、給油せず、queにGSを追加する
    val reachEnabled: Boolean = (nextStation._1 <= track.distanceFromStart + track.remainGas)
    if(reachEnabled){
      if(presentStation._1 > 0){
       pq.enqueue(presentStation)
      }
      return new Track(presentStation._1,
        track.remainGas - (presentStation._1 - track.distanceFromStart)
      )
    }else{
      //給油しないと次のGSまで行けない計算であれば、給油する
      usedGasStationList+=presentStation
      //給油する
      var nextRemainGas: Int = track.remainGas - (presentStation._1 - track.distanceFromStart) + presentStation._2
      val reachNextStationEnabled: Boolean = nextRemainGas - (nextStation._1 - presentStation._1) >= 0
      if(!reachNextStationEnabled){
        //給油してもダメならqueから一番いいやつを取ってきて給油したことにする
        for (i <- 0 until pq.length){
          if(nextRemainGas - (nextStation._1 - presentStation._1) < 0){
            val queStation: (Int, Int) = pq.dequeue()
            //給油する
            nextRemainGas += queStation._2
            usedGasStationList+=queStation
          }
        }
      }
      new Track(presentStation._1, nextRemainGas)
    }
  }
}

class Track(val distanceFromStart: Int, val remainGas:Int) {
}
