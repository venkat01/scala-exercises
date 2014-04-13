package pl.net.stepniak.traits

import org.specs2.mutable.Specification

class PeopleRepositoryTest extends Specification {

  "PeopleRepository" should {
    "not find any user in empty list" in {
      val repository = new PeopleRepository with SimpleLogger {
        override lazy val people = List()
      }

      repository.findTheLongestName() must beNone
    }

    "find Aleksander as a longest name in repository" in {
      val repository = new PeopleRepository with NullLogger {
        override lazy val people = List("Marian", "Jan", "Grzegorz", "Aleksander")
      }

      repository.findTheLongestName() mustEqual Some("Aleksander")
    }
  }
}
