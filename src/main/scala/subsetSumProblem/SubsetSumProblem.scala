/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/03/25
 * Time: 23:51
 * To change this template use File | Settings | File Templates.
 */
class SubsetSumProblem {
  def execute(args: Array[String]):Unit = {
    val numList: List[Int] = List(1, 10, 49, 3, 8, 13, 7, 23, 60, -500, 42, 599, 45, -23, 1, 10, 49, 3 , 8, 13)
    val sum: Int = 444

    //todo:sumと同じ数値がnumListにある場合は、numListの数字たちをgetSumsの返り値から取り除く必要あり
    if (getSums(numList, sum).contains(sum)) {
      println("YES") //どの値が足し合わさってこの値ができたか分からない
    }else{
      println("NO")
    }
  }

  def getSums(numList: List[Int], sum: Int): List[Int] = {
    if (numList.length == 1){
      return numList
    }else{
      val sums: List[Int] = getSums(numList.tail, sum)
      if (sums.contains(sum)) {
        return sums
      }
      sums ++ sums.map(n => n+numList.head) :+ numList.head
    }
  }
}
