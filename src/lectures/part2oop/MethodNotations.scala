package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def unary_! : String = s"$name, what the heck!!"
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is ${name} and I like ${favoriteMovie}"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))
  println(mary likes "Inception") // equivalent
  // Infix notation

  //   operator notation --> only with methods with 1 argument
  // syntatic sugar

  // "operators" in scala
  val tom = new Person("Tom", "Fight Club")
  println(mary + tom)

  // All operators are methods
  println(1 + 2)
  println(1.+(2))

  // Prefix notation
  val x = -1
  val y = 1.unary_-

  println(!mary)
  println(mary.unary_!)

  // Postfix notation (only for methods without parameters)
  println(mary.isAlive)
  //println(mary isAlive)

  // Apply
  println(mary.apply())
  println(mary()) // equivalent
}
