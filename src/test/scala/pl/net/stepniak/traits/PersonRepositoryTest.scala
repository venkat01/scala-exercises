package pl.net.stepniak.traits

import org.specs2.mutable.Specification

class PersonRepositoryTest extends Specification {

  "PeopleRepository" should {
    "not find any user in empty list" in {
      val repository = new PersonRepository with SimpleLogger {
        override lazy val people = List()
      }

      repository.findPersonLongestName() must beNone
    }

    "find Aleksander as a longest name in repository" in {
      val repository = new PersonRepository with NullLogger {
        override lazy val people = List("Marian", "Jan", "Grzegorz", "Aleksander")
      }

      repository.findPersonLongestName() mustEqual Some("Aleksander")
    }
  }
}
