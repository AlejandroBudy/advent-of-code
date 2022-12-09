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
  val result = Reader
    .fromFile("src/resources/day2")
    .split("\n")
    .toList
    .map(calculatePoints)
    .sum

  println(result)
}

object DayTwo_part2 extends App {

  private def calculateShape(str: String): Int = {
    val opponent :: mine = str.split(' ').toList
    val chosenPoint = mine.head.toUpperCase match {
      case "X" => 0
      case "Y" => 3
      case "Z" => 6
    }
    val shape = (opponent.toUpperCase, mine.head.toUpperCase) match {
      case ("A", "X") => "Z"
      case ("A", "Y") => "X"
      case ("A", "Z") => "Y"
      case ("B", "X") => "X"
      case ("B", "Y") => "Y"
      case ("B", "Z") => "Z"
      case ("C", "X") => "Y"
      case ("C", "Y") => "Z"
      case ("C", "Z") => "X"
    }
    val points = shape match {
      case "X" => 1
      case "Y" => 2
      case "Z" => 3
    }

    chosenPoint + points
  }

  val result = Reader
    .fromFile("src/resources/day2")
    .split("\n")
    .toList
    .map(calculateShape)
    .sum

  println(result)
}
