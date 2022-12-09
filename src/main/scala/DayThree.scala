object DayThree extends App {

  private lazy val scores = {
    val map = scala.collection.mutable.Map[String, Int]()
    for ((c, i) <- (('a' to 'z') ++ ('A' to 'Z')).zipWithIndex)
      map += (c.toString -> (i + 1))
    map
  }

  private def part1: Int = {
    val input = Reader.fromFile("src/resources/day3").split("\n").toList

    input
      .map(_.split("").toSeq)
      .map { l =>
        val (s1, s2) = l.splitAt(l.length / 2)
        s1.intersect(s2).distinct
      }
      .map(_.map(scores(_)).sum)
      .sum
  }

  private def part2: Int = {
    val input = Reader.fromFile("src/resources/day3").split("\n").toList.grouped(3)

    input
      .map(_.zipWithIndex.foldLeft(List.empty[String]) { case (acc, (l, idx)) =>
        if (idx == 0) l.split("").toList else acc.intersect(l.split("").toList).distinct
      })
      .map(_.map(scores(_)).sum)
      .sum
  }

  println(part2)
}
