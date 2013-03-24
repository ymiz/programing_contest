object main
{
  //val labyrinthWords = "#S######.#\n......#..#\n.#.##.##.#\n.#........\n##.##.####\n....#....#\n.#######.#\n....#.....\n.####.###.\n....#...G#"
  val labyrinthWords = ".S.#.##.####.##....#..#..#........................\n.#.#............##.#.###.#.###.##################.\n##.#.#############.#..#..#...#.#.....#......#.#.#.\n...#...#........##.#....####.#.##.#..#.###......#.\n.#.#.#....#.######.#.#.......#.#..#........###..#.\n.######.###.#...##.#.#.#.##..#.#.#########.#.##.#.\n..........#.#.#.##.#.#######.#.#.#...#...#.#.#..#.\n.#.########.#.#.##.#....##.#.#.#.#.#.#...#.#.#..#.\n.#.##.#.#.#.#.#.#..#.##......#.#.#.#...#.#.#.#..#.\n.#....#.#.#.#.#.#.##.#########.#.#######.#.#.#.##.\n#######.#...#.#.#......#.....#.#.........#.#.#..#.\n..#...#.#.#.#.#.#..#####.#.#.#.###########.#.#..#.\n......#.#.#...#.#......#..#..#.....#.......#.#..#.\n#####.#.#.#####.#####..#.....#..##...#.#...#.##.#.\n..#...#.#.#.###.#.########.#########.#.#...#.#..#.\n..#.#...#.#.......#..#.................###.#.#..#.\n....#.....#.#####.#.##.#################...#....#.\n.##########.#.#.#.#..#..#..#.........#.#..#######.\n.#..#.....#.....#.#.###.#.....#####....#..#.......\n...##.#.#....##.#.#..#..#.##########.#.##.#.######\n.#..#.#.#.#######.##.#.##.#..........#.##.#...####\n.##.#####.#.......##....#.#.########.#.##.#.#.#...\n#####.....#############.###.#.....##.#.##.#.#.#.#.\n.......#..............#...#.#####.##.#.##.#.#.#.#.\n####.####.............###.#.#####.##.#.##.#.#.#.#.\n...#.#..................#.#.......##.#.##.#.#.#.#.\n.#.#....###..###........#.##########.#.##.#.#.#.#.\n.#.#.#.#.....#..........#............#.##.#.#.#.#.\n.#.#...###...#.###......#.############.##.#.###.#.\n.#.#.#....#..#..#.......#.#.#############.#..##.#.\n.#.#......#..#..#.......#.#.#.............##.##.#.\n.#.#.#.###...####.......#.#.#.##############.##.#.\n.#.#....................#.#.#.#...........##.##.#.\n.#.#.#......###..###....#.#.#.#.############.##.#.\n.#.#.......#.....#......#.#.#.#.############.##.#.\n.#.#.#.....###...#.###..#.#.#.#.#.........##.##.#.\n.#.#..........#..#..#...#.#.#.#.#.#######.##.##.#.\n.#.#.#........#..#..#...#.#.#.#.#.#.#G#.#.##.##.#.\n.#.#.#.....###...####...#.#.#.#.#.#.#.#.#.##.##.#.\n.#.#.#..................#.#.#.#.#.#.#.#.#.##.##.#.\n.#.#.#...###..###.......#.#.#.#.#.#.......##.##.#.\n.#.#.#..#.....#.....###.#.#.#.#.#.##########.##.#.\n.#.#.#..###...#.###.#.#.#.#.#.#.#............##.#.\n.#.#.#.....#..#..#..#.#.#.#.#.#.###############.#.\n.#.#.#.....#..#..#..#.#.#.#.#.#.###############.#.\n.#.#.#..###...####..#.#.#.#.#.#.................#.\n.#.#.#..............#.#.#.#.#.###################.\n.#..................#...#.#.#.....................\n.########################.#.#####################.\n..........................#......................."

  def main(args: Array[String]):Unit = {
    //文字列から迷路オブジェクトを作成
    val labyrinth = (new LabyrinthFactory).createByRawString(labyrinthWords)

    //探索オブジェクト生成
    val explore: Explore = new Explore()

    //Sの座標をargsから取得
    val startX: Int = args(0).toInt
    val startY: Int = args(1).toInt

    //Sの座標を探索オブジェクトに渡して、探索
    println(explore.locateGoal(labyrinth, labyrinth.getByCoordinate(startX, startY)).turn)
  }
}