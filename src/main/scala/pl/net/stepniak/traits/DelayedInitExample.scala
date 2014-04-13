package pl.net.stepniak.traits

/**
 * DelayedInit example usage
 */
trait DelayedInitExample extends DelayedInit {

  var message: Option[String] = None

  override def delayedInit(init: => Unit) = init

  def displayMessage(): Unit = message.foreach { msg => println(s"Message: $msg") }
}
