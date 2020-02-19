package lectures.part2oop

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-19
 */

object CaseClasses extends App{

  /*
  equals, cashCode, toString,...
   */

  case class Person(name: String, age: Int)

  // 1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  // 2. sensible toString
  // println(instance) = println(instance.toString) // syntatcic sugar
  // println(jim.toString)
  println(jim)

  // 3. equals and hashCode implemented OOTB
  val jim2 = new Person("Jim", 34)
  println(jim == jim2) // true

  // 4. Case Classes have handy copy methods
  val jim3 = jim.copy(age = 45)
  println(jim3)

  // 5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 23) // 'apply' method --> same thing as the constructor

  // 6. CCs are serializable
  // nice for Akka

  // 7. CCs have extractor patterns = CCs can be used in PATTERN MATCHING

  case object UnitedKingdom {
    def name: String = "The UK of GB and NI"
  }

  /*
  Expand MyList - use case classes and cas objects
   */

}
