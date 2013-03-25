package shortestPath

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/03/20
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
class Labyrinth(coordinateList:List[List[LabyrinthPanel]]) {
  def getByCoordinate(x:Int, y:Int): LabyrinthPanel = { coordinateList(y)(x)}
  def hasByCoordinate(x: Int, y: Int): Boolean = {
    if (!coordinateList.isDefinedAt(y)) return false
    coordinateList.isDefinedAt(x)
  }
}
