package pl.net.stepniak.typeclasses

import org.specs2.mutable.Specification
import java.io.{FileReader, PrintWriter, File}
import scala.io.Source

class SynchUtil$Test extends Specification {

  import SynchUtil._

  val fromFileName = "/tmp/fromFile.tmp"
  val fromFileContent = "Lorem ipsum dolor sit amet"
  val toFileName = "/tmp/toFile.tmp"
  val toFileContent = "poijnm,asdn,asd"

  def createFileWithContent(name: String, content: String): Unit = {
    val writer = new PrintWriter(new File(name))
    writer.write(content)
    writer.close()
  }

  def getFileContent(file: File) = Source.fromFile(file).mkString

  "Synchronizing FileLike object" should {
    "copy contents from the first file to the second one" in {
      //setup:
      createFileWithContent(fromFileName, fromFileContent)
      createFileWithContent(toFileName, toFileContent)
      val fromFile = new File(fromFileName)
      val toFile = new File(toFileName)
      //when:
      synchronize(fromFile, toFile)
      //then:
      getFileContent(toFile) mustEqual fromFileContent
    }
  }
}
