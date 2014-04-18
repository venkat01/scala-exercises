package pl.net.stepniak.collections

import org.specs2.mutable.Specification
import java.io.{File, PrintWriter}
import org.specs2.mock.Mockito

class FileLineTraversableTest extends Specification with Mockito {

  import FileLineTraversable._

  val testFileContent: String = "Linia 1\nLinia 2\n Linia 3"
  val testFileName = "/tmp/lorem.txt"

  def createTestFile(name: String) = {
    val writer = new PrintWriter(new File(name))
    writer.write(testFileContent)
    writer.close()
  }

  createTestFile(testFileName)

  "FileLineTraversable" should {
    "apply given callback 3 times" in {
      //setup:
      val mockCallback = mock[String => Unit]
      //when:
      val fileLineTraversable = new FileLineTraversable(new File(testFileName))
      fileLineTraversable.foreach(mockCallback)
      //then:
      there was three(mockCallback).apply(any[String])
    }
  }
}
