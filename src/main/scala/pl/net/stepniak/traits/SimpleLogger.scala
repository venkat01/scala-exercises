package pl.net.stepniak.traits

trait SimpleLogger extends Logger {
  override def log(msg: String) = println(msg)
}
