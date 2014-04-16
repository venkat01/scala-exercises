package pl.net.stepniak.types

import org.specs2.mutable.Specification

class TypesHolder$Test extends Specification {

  import TypesHolder._

  "RandomIntGenerator" should {
    "return non nullable value" in {
      (randomIntGenerator() must not).beNull
    }
  }

  "Computing square function" should {
    "return 0 for paramater 0" in {
      sqrt(0) mustEqual 0
    }

    "return positivie result for negative input" in {
      sqrt(-20) mustEqual 400
    }
  }
}
