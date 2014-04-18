package pl.net.stepniak.collections

import java.io.{FileReader, BufferedReader, File}
import pl.net.stepniak.traits.{SimpleLogger, Logger}

/**
 * Code example from page 200.
 */
class FileLineTraversable(file: File)(implicit val logger: Logger) extends Traversable[String] {
  override def foreach[U](f: String => U): Unit = {
    logger.log("Otwieram plik")
    val input = new BufferedReader(new FileReader(file))
    try {
      var line = input.readLine
      while (line != null) {
        f(line)
        line = input.readLine
      }
      logger.log("Przerwarzanie pliku zakonczone")
    } finally {
      logger.log("Zamykam plik")
      input.close
    }
  }

  override def toString = s"{Linie ${file.getAbsolutePath}}"
}

object FileLineTraversable {
  implicit val defaultLogger = new SimpleLogger {}
}
