import scala.io.Source

object Reader {

  def fromFile(filePath: String): String =
    Source
      .fromFile(filePath)
      .mkString
}
