package EcologicalChain

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/06/28
 * Time: 8:32
 * To change this template use File | Settings | File Templates.
 */
class AnimalTree(val animalList: List[Animal]) {
  def findRoot(animalIndex: Int): Int = {
    animalList(animalIndex).parentIndex
  }
  def unite(animalXIndex: Int, animalYIndex: Int): Unit = {
    val xRootIndex: Int = findRoot(animalXIndex)
    val yRootIndex: Int = findRoot(animalYIndex)
    //親が一緒＝グループが一緒であれば何もしない
    if(xRootIndex == yRootIndex){ return }
    val xRootAnimal: Animal = animalList(xRootIndex)
    val yRootAnimal: Animal = animalList(yRootIndex)
    if(xRootAnimal.rank < yRootAnimal.rank){
      animalList(xRootIndex).setParentIndex(yRootIndex)
    }else{
      animalList(yRootIndex).setParentIndex(xRootIndex)
      if(xRootAnimal.rank == yRootAnimal.rank){
        xRootAnimal.incrementRank()
      }
    }
  }
  def isSameGroup(animalXIndex: Int, animalYIndex: Int): Boolean = {
    findRoot(animalXIndex) == findRoot(animalYIndex)
  }
}
