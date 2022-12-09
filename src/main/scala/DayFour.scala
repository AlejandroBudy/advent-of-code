object DayFour extends App {

  private def part2: Int = Reader
    .fromFile("src/resources/day4")
    .split('\n')
    .toList
    .map { l =>
      val first :: second            = l.split(',').toList
      val firstUpper :: firstLower   = first.split('-').toList.map(_.toInt)
      val secondUpper :: secondLower = second.head.split('-').toList.map(_.toInt)

      if ((firstUpper to firstLower.head).intersect((secondUpper to secondLower.head)).nonEmpty) 1
      else 0

    }
    .sum

  private def part1: Int = Reader
    .fromFile("src/resources/day4")
    .split('\n')
    .toList
    .map { l =>
      val first :: second            = l.split(',').toList
      val firstUpper :: firstLower   = first.split('-').toList.map(_.toInt)
      val secondUpper :: secondLower = second.head.split('-').toList.map(_.toInt)

      if (firstUpper <= secondUpper && firstLower.head >= secondLower.head) 1
      else if (firstUpper >= secondUpper && firstLower.head <= secondLower.head) 1
      else 0
    }
    .sum

  println(part2)
}
