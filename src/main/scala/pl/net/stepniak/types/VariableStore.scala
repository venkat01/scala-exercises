package pl.net.stepniak.types

class VariableStore(private var value: Int) extends Observable with DefaultHandles {
  def get: Int = value
  def set(newValue: Int): Unit = {
    value = newValue
    notifyListeners()
  }

  override def toString: String = s"VariableStore($value)"
}
