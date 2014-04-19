package pl.net.stepniak.collections

import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable
import scala.collection.script.Message

object ArrayBufferExample {

  val buffer = new ArrayBuffer[Int]() with mutable.ObservableBuffer[Int] {
    subscribe(new Sub {
      override def notify(pub: Pub, event: Message[Int] with mutable.Undoable): Unit = {
        Console.println(s"Zdarzenie $event z $pub")
      }
    })
  }
}
