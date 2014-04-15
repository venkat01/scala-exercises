package pl.net.stepniak.types

import org.specs2.mutable.Specification
import org.specs2.mock.Mockito

class VariableStoreTest extends Specification with Mockito {

  val initValue = 40
  val newValue = 30

  "VariableStore" should {
    "returns value set while constructing object" in {
      val variableStore = new VariableStore(5)
      variableStore.get mustEqual 5
    }

    "notify listeners when new value is set" in {
      //setup:
      val firstHandle = mock[(VariableStore => Unit)]
      val secondHandle = mock[(VariableStore => Unit)]
      val variableStore = createVariableStoreForTests(initValue, Seq(firstHandle, secondHandle))

      //when:
      variableStore.set(newValue)

      //then:
      there was one(firstHandle).apply(variableStore)
      there was one(secondHandle).apply(variableStore)
    }

    "not notify listeners that got unobserve" in {
      //setup:
      val firstHandle = mock[(VariableStore => Unit)]
      val secondHandle = mock[(VariableStore => Unit)]
      val variableStore = createVariableStoreForTests(initValue, Seq(firstHandle, secondHandle))
      variableStore.unobserve(secondHandle)

      //when:
      variableStore.set(newValue)

      //then:
      there was no(secondHandle).apply(variableStore)
    }
  }

  def createVariableStoreForTests(value: Int, observators: Seq[(VariableStore => Unit)]) = {
    val variableStore = new VariableStore(value)
    observators foreach { variableStore.observe(_) }
    variableStore
  }
}
