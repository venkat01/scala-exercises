package pl.net.stepniak.traits

import org.specs2.mutable.Specification

class DelayedInitExampleTest extends Specification {

  "DelayedInitExample" should {
    "not display any message if it was not set in delayed init" in {
      val example = new DelayedInitExample { println("asd") }
      example.message must beNone
    }

    "display message passed in init anonymous function" in {
      val example = new DelayedInitExample {
        message = Some("Lorem ipsum dolor sit amet")
      }
      example.displayMessage()
      example.message mustEqual Some("Lorem ipsum dolor sit amet")
    }
  }
}
