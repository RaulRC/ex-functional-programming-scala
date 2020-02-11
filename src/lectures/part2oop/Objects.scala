package lectures.part2oop

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-11
 */

object Objects extends App{

  // Scala does not have class-level functionality ("static")
  object Person { // Type and its only instance
    // "static/class" level functionallity
    val N_EYES = 2
    def canFly: Boolean = false
  }

  class Person {
    // instance level functionallity
  }
  // COMPANIONS design pattern

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON instance

  val mary = Person
  val john = Person
  println(mary == john) // point to the same instance (SINGLETON)
}
