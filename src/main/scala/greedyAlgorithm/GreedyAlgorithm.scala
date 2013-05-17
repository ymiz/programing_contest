package greedyAlgorithm

import collection.mutable
/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/05/04
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
class GreedyAlgorithm {
  val n: Int = 100
  val s: List[Int] = List(19, 34, 5, 39, 6, 17, 43, 13, 33, 6, 25, 10, 3, 32, 30, 25, 23, 20, 38, 31, 39, 10, 34, 47, 49, 37, 19, 28, 20, 17, 22, 20, 40, 0, 20, 6, 49, 46, 0, 23, 41, 13, 0, 14, 49, 41, 36, 46, 3, 28, 27, 29, 22, 37, 47, 16, 31, 14, 30, 27, 35, 49, 0, 44, 40, 49, 41, 1, 6, 39, 37, 4, 39, 10, 31, 3, 37, 18, 47, 13, 47, 33, 4, 0, 34, 36, 42, 17, 1, 38, 30, 35, 8, 5, 1, 4, 7, 17, 26, 35)
  val t: List[Int] = List(34, 67, 39, 62, 32, 49, 50, 13, 43, 23, 25, 16, 48, 51, 37, 68, 46, 42, 51, 49, 76, 14, 79, 48, 87, 73, 54, 34, 65, 23, 44, 51, 49, 3, 41, 7, 86, 72, 25, 30, 63, 13, 39, 27, 88, 89, 57, 46, 31, 58, 61, 75, 34, 85, 93, 49, 54, 61, 56, 72, 54, 51, 6, 46, 50, 59, 73, 33, 31, 86, 61, 37, 81, 16, 64, 39, 85, 42, 57, 40, 62, 69, 28, 30, 38, 57, 66, 47, 36, 38, 35, 45, 30, 46, 45, 37, 16, 26, 42, 43)
  //どういう順番で仕事をこなすかを格納する
  var resultTaskIndexList :mutable.MutableList[Int] = mutable.MutableList.empty[Int]
  def execute():Unit = {
    //終了時間にindexをつけてソートする
    //(value,index),(value,index),...のリストになる。
    //具体的には(3,33),(6,62),(7,35),(13,7),...というリストになる。
    val tWithIndex :List[(Int, Int)] = t.zipWithIndex.sorted
    //最初の仕事の終了時間と最初の仕事のindexを取り出す
    val (firstTTime :Int, firstTaskIndex: Int) = tWithIndex.sorted.head
    //最初の仕事を結果に格納
    resultTaskIndexList = resultTaskIndexList :+ firstTaskIndex
    //下のfor文で使う。前の仕事の終了時間
    var preTTime :Int = firstTTime
    //残り時間が多くなるように取っていく
    tWithIndex.foreach(eachT =>
      preTTime = resolveTask(eachT, preTTime)
    )
    //仕事をいくつできるか出力
    println(resultTaskIndexList.length)
    //どの仕事をこなすことができるか出力
    resultTaskIndexList.foreach(result=>println(s(result),t(result)))
  }

  private def resolveTask(eachT:(Int,Int), preTTime:Int):Int = {
    //tTimeは仕事終了時間、tIndexは仕事のindexを表す
    val (tTime :Int, tIndex :Int) = eachT;
    //調査対象仕事の開始時間が前の仕事の終了時間よりも未来であれば採用
    if (s(tIndex) > preTTime){
      resultTaskIndexList = resultTaskIndexList :+ tIndex
      return tTime
    }
    preTTime
  }

}
