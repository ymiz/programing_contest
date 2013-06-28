package EcologicalChain

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/06/28
 * Time: 8:23
 * To change this template use File | Settings | File Templates.
 */
class Animal(var parentIndex: Int, var rank: Int) {
  def setParentIndex(index: Int): Unit = {
    parentIndex = index
  }
  def incrementRank(): Unit = {
    rank = rank+1
  }
}
