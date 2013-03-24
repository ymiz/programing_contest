import collection.mutable

/**
 * Created with IntelliJ IDEA.
 * User: una
 * Date: 2013/03/24
 * Time: 3:45
 * To change this template use File | Settings | File Templates.
 */
class Explore {

  def locateGoal(labyrinth:Labyrinth, startPanel:LabyrinthPanel): LabyrinthGoal = {
    var exploreQueue :mutable.Queue[List[LabyrinthPanel]] = new mutable.Queue()
    exploreQueue.enqueue(List(startPanel))
    processQueue(0, labyrinth, exploreQueue, List.empty)
  }

  private def processQueue(
                    turn: Int,
                    labyrinth: Labyrinth,
                    exploreQueue: mutable.Queue[List[LabyrinthPanel]],
                    alreadyExploreList: List[LabyrinthPanel]): LabyrinthGoal = {
    //todo:なんかもっとこういい感じの処理
    if (exploreQueue.isEmpty) return new LabyrinthGoal(null, -1)

    val panelList:List[LabyrinthPanel] = exploreQueue.dequeue()

    //今回探索したpanelを格納するlist
    var exploreOnThisTurnList: mutable.MutableList[LabyrinthPanel] = mutable.MutableList.empty[LabyrinthPanel]

    //ゴールがあれば終わり
    panelList.foreach(panel =>
      if(panel.isGoal()) return new LabyrinthGoal(panel, turn)
    )

    //今回探索するpanelを格納
    panelList.foreach(panel =>
      exploreOnThisTurnList = exploreOnThisTurnList :+ panel
    )

    //前回までに探索済みのpanelと今回探索したpanel、どちらも格納されたlist
    val nextAlreadyExploreList: List[LabyrinthPanel] = alreadyExploreList ++ exploreOnThisTurnList.toList

    //通路とstartだけ残す
    val roadPanelList: List[LabyrinthPanel] = panelList.filter(p => p.isRoad() || p.isStart())

    //次回探索するpanelのlistをつくる
    val nextPanelListArr: Array[List[LabyrinthPanel]] = new Array[List[LabyrinthPanel]](roadPanelList.length)
    for (i <- 0 until roadPanelList.length){
      nextPanelListArr(i) = getNextPanelList(roadPanelList(i), labyrinth).filter(
        p => !isAlreadyExplore(p, nextAlreadyExploreList)
      )
    }

    //探索予定パネルをキューに積む
    //todo:これキューの必要ないじゃん
    exploreQueue.enqueue(removeDuplicates(nextPanelListArr.toList.flatten))

    //ターン更新
    val nextTurn: Int = turn + 1

    //もっかい
    processQueue(nextTurn, labyrinth, exploreQueue, nextAlreadyExploreList)
  }

  private def getNextPanelList(panel: LabyrinthPanel, labyrinth: Labyrinth): List[LabyrinthPanel] = {
    val panelX :Int = panel.x
    val panelY :Int = panel.y

    //todo:何か良い書き方ないものか
    val nextPanel1: LabyrinthPanel = getNextPanel(panelX-1, panelY, labyrinth)
    val nextPanel2: LabyrinthPanel = getNextPanel(panelX+1, panelY, labyrinth)
    val nextPanel3: LabyrinthPanel = getNextPanel(panelX, panelY-1, labyrinth)
    val nextPanel4: LabyrinthPanel = getNextPanel(panelX, panelY+1, labyrinth)

    List(nextPanel1, nextPanel2, nextPanel3, nextPanel4).filter(_ != null)
  }

  private def getNextPanel(x: Int, y: Int, labyrinth: Labyrinth): LabyrinthPanel = {
    if (labyrinth.hasByCoordinate(x, y)){
      return labyrinth.getByCoordinate(x, y)
    }else{
      return null
    }
  }

  private def isAlreadyExplore(panel: LabyrinthPanel, list: List[LabyrinthPanel]): Boolean = {
    list.foreach(l =>
      if (l.equals(panel)){
        return true
      }
    )
    false
  }

  private def removeDuplicates(panelList: List[LabyrinthPanel]): List[LabyrinthPanel] = {
    if (panelList.isEmpty){
      panelList
    }else{
      //先頭要素と、重複を省いた要素をくっつける
      panelList.head :: removeDuplicates(
        //先頭要素以外のリスト内で、先頭要素と同じものは省く
        panelList.tail.filter(p => !p.equals(panelList.head))
      )
    }
  }

}
