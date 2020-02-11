package lectures.part2oop

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-11
 */

object Objects {

  // Scala does not have class-level functionality ("static")
  object Person { // Type and its only instance
    // "static/class" level functionallity
    val N_EYES = 2
    def canFly: Boolean = false

    // factory method
    // -- build persons given some parameters
    // apply, from
    def apply(mother: Person, father: Person): Person = new Person("Bobbie")

  }

  class Person(val name: String){
    // instance level functionallity
  }
  // COMPANIONS design pattern
  def main(args: Array[String]): Unit = {
    println(Person.N_EYES)
    println(Person.canFly)

    // Scala object = SINGLETON instance

    val mary = Person
    val john = Person
    println(mary == john) // point to the same instance (SINGLETON)

    val mary2 = new Person("Mary")
    val john2 = new Person("John")
    println(mary2 == john2) // false; different instances (new)

    val bobbie = Person(mary2, john2) // apply, from


    // Scala Applications = Scala object with
    // def main(args: Array[String]: Unit
  }

}
