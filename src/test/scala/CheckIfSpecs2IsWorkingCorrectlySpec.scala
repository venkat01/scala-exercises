import org.specs2.mutable._

class CheckIfSpecs2IsWorkingCorrectlySpec extends Specification {

  val someSimpleList = List(1,2,3,4)

  "Working Specs2" should {
    "succeed in summing up all someSimpleList elements" in {
      someSimpleList.sum mustEqual 10
    }
  }
}
