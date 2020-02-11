package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String, val age: Int = 0){
    def likes(movie: String): Boolean = movie == favoriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(nickname: String): Person = new Person(s"${this.name} (${nickname})", this.favoriteMovie)
    def unary_! : String = s"$name, what the heck!!"
    // unary only works for +, -, !, ~
    def isAlive: Boolean = true
    def apply(): String = s"Hi, my name is ${name} and I like ${favoriteMovie}"
    def apply(times: Int): String = s"${name} watched ${favoriteMovie} ${times} time(s)"
    def unary_+ : Person = new Person(this.name, this.favoriteMovie, this.age + 1)
    def learns(what: String): String = s"${name} learns ${what}"
    def learnsScala: String = this learns "Scala"
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


  /* Exercises
  1. Overload the + operator
  mary + "the rockstar" => new Person("Mary (the rockstar"))

  2. Add age to the person
  unary operator + increments 1
  +mary => new person mary

  3. Add a "learns" method => Mary learns Scala
  "learnsScala" calls learns method with Scala
  Use it in postfix notation

  4. Overload apply
  mary.apply(2) => "Mary watched inception 2 times"
   */

  // 1.

  val another = mary + "the rockstar"
  println(another())

  // 2.

  val maryAge = +mary
  println(maryAge.age)

  // 3.

  println(mary.learnsScala)

  // 4.

  println(mary(5))
}
