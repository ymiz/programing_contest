/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/03/20
 * Time: 21:09
 * To change this template use File | Settings | File Templates.
 */
class LabyrinthPanel(val x: Int, val y: Int, label: String) {
  val wallLabel = "#"
  val startLabel = "S"
  val roadLabel = "."
  val goalLabel = "G"

  def isGoal(): Boolean = {label == goalLabel}
  def isRoad(): Boolean = {label == roadLabel}
  def isStart(): Boolean = {label == startLabel}
  def equals(panel: LabyrinthPanel): Boolean = {
    panel.x == x && panel.y == y
  }
}
