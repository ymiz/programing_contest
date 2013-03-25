package shortestPath

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/03/20
 * Time: 22:20
 * To change this template use File | Settings | File Templates.
 */
class LabyrinthFactory {
  def createByRawString(rawString: String): Labyrinth = {
    //todo:気が向いたら書きなおす
    val yCoordinateArr: Array[String] = rawString.split("\n")
    val CoordinateArr: Array[Array[LabyrinthPanel]] = new Array(yCoordinateArr.length)
    for (i <- 0 until yCoordinateArr.length) {
      val xCoordinateArr: Array[String] = yCoordinateArr(i).toArray.map(c => c.toString)
      val tempArr: Array[LabyrinthPanel] = new Array(xCoordinateArr.length)
      for (j <- 0 until xCoordinateArr.length) {
        tempArr(j) = new LabyrinthPanel(j, i, xCoordinateArr(j))
      }
      CoordinateArr(i) = tempArr
    }
    new Labyrinth(CoordinateArr.toList.map(a => a.toList))
  }
}
