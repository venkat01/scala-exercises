package pl.net.stepniak.traits

trait PersonRepository extends Logger {

  lazy val people = List[String]()

  def findPersonLongestName(): Option[String] = people.reduceLeftOption { (x,y) => if (x.length > y.length) x else y }

  def countAll(): Int = people.size
}
