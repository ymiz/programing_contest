/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/03/25
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
class SubsetSumProblem {
  def execute(args: Array[String]):Unit = {
    val start = System.currentTimeMillis

    val numList: List[Int] = List(1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8, 13)
    val sum: Int = 444

    if (findTargetSum(List(numList.head), numList.tail, List(), sum)){
      println("YES") //どの値が足し合わさってこの値ができたか分からない！
    }else{
      println("NO")
    }

    println((System.currentTimeMillis - start) + "msec") //時間計測用
  }

  /**
   *
   * @param doneList 与えられた数値の中で、すでに足しあわせた値のリスト
   * @param remainList 与えられた数値の中で、まだ足しあわせしてない値のリスト
   * @param sumList 合計値のリスト
   * @param targetSum 探索する合計値
   * @return boolean 合計値を発見したかどうか
   */
  def findTargetSum(doneList: List[Int], remainList: List[Int], sumList: List[Int], targetSum: Int): Boolean = {
    if (sumList.contains(targetSum)){
      return true
    }
    if (remainList.isEmpty){
      return false
    }
    val newDoneList: List[Int] = doneList :+ remainList.head
    val newRemainList: List[Int] = remainList.tail
    val newSumList: List[Int] = sumList ++ sumList.++(doneList).map(n => n + remainList.head)
    findTargetSum(newDoneList, newRemainList, newSumList, targetSum)
  }

}
