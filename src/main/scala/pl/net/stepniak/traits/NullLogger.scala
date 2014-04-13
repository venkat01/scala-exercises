package pl.net.stepniak.traits

trait NullLogger extends Logger {
  override def log(msg: String) = {}
}
