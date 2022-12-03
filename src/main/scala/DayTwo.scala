import scala.io.Source

object DayTwo_part1 extends App {

  private def calculatePoints(string: String): Int = {
    val opponent :: mine = string.split(' ').toList
    val chosenPoint = mine.head.toUpperCase match {
      case "X" => 1
      case "Y" => 2
      case "Z" => 3
    }
    val winnerPoints = (opponent.toUpperCase, mine.head.toUpperCase) match {
      case ("C", "X") => 6
      case ("A", "Y") => 6
      case ("B", "Z") => 6
      case ("C", "Z") => 3
      case ("A", "X") => 3
      case ("B", "Y") => 3
      case _          => 0
    }

    chosenPoint + winnerPoints
  }
  val input = Source
    .fromFile("src/resources/day2")
    .mkString
    .split("\n")
    .toList
    .map(calculatePoints)
    .sum

  println(input)
}
