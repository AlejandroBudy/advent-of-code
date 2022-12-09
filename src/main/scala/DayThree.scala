object DayThree extends App {

  private def getScore(s: String): Int = {
    val map = scala.collection.mutable.Map[String, Int]()
    for ((c, i) <- (('a' to 'z') ++ ('A' to 'Z')).zipWithIndex)
      map += (c.toString -> (i + 1))

    println(s"Looking for $s")
    val value = map(s)
    println(s"Found with value: $value")
    value
  }
  private def part1: Int = {
    val input = Reader.fromFile("src/resources/day3").split("\n").toList

    input
      .map(_.split("").toSeq)
      .map { l =>
        val (s1, s2) = l.splitAt(l.length / 2)
        s1.intersect(s2).distinct
      }
      .map(_.map(getScore).sum)
      .sum
  }

  println(part1)
}
