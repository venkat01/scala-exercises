package pl.net.stepniak.traits

trait PeopleRepository extends Logger {

  lazy val people = List[String]()

  def findTheLongestName(): Option[String] = people.reduceLeftOption { (x,y) => if (x.length > y.length) x else y }

  def countPeople(): Int = people.size
}
