import scala.io.Source

object DayOne_Part1 extends App {

  val result =
    Source
      .fromFile("src/resources/day1")
      .mkString
      .split("\n\n")
      .toList
      .map(
        _.split("\n")
          .filterNot(_.isEmpty)
          .map(_.toInt)
          .toList
          .sum
      ).max

  println(result)
}

object DayOne_Par1 extends App {

  val result =
    Source
      .fromFile("src/resources/day1")
      .mkString
      .split("\n\n")
      .toList
      .map(
        _.split("\n")
          .filterNot(_.isEmpty)
          .map(_.toInt)
          .toList
          .sum
      )
      .sorted(Ordering[Int].reverse)
      .take(3)
      .sum

  println(result)
}
