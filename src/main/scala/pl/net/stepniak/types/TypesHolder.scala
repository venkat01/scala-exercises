package pl.net.stepniak.types

import scala.util.Random

object TypesHolder {

  type Consumer[T] = (T) => Unit
  type Supplier[T] = () => T
  type Callback[T,U] = (T) => U
  type Predicate[T] = (T) => Boolean

  def randomIntGenerator: Supplier[Int] = () => Random.nextInt()

  def logger: Consumer[String] = msg => println(s"logger: $msg")

  def sqrt: Callback[Int,Int] = x => x*x

  def isEven: Predicate[Int] = x => x % 2 == 0
}
