package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Raúl", 34)
  println(person.x)
  person.greet("Daniel")
  person.greet()

}

//constructor
class Person(name: String, val age: Int = 0){

  // body
  val x = 2 // MEMBER

  println(1+3) // BLOCK CODES WILL BE EVALUATED DURING INSTANTIATION

  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  // Overloading
  def greet(): Unit = println(s"Hi, I am $name")

  // multiple constructors
  // auxiliary constructors calling the base
  def this(name: String) = this(name, 0)

  def this() = this("John Doe")
}



// class parameters are NOT FIELDS

// use val to add that value