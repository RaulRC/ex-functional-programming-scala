package lectures.part2oop

object OOBasics extends App {

  val person = new Person("Raúl", 34)
  println(person.x)
  person.greet("Daniel")
  person.greet()

  println("Exercise\n==============")
  val author = new Writer("Charles", "Dickens", 1812)
  val impostor = new Writer("Charles", "Dickens", 1812)
  val novel = new Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.increment.print
  counter.increment.increment.increment.print
  counter.increment(10).print

}

//constructor
class Person(name: String, val age: Int = 0){
  // class parameters are NOT FIELDS
  // use val to add that value
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


/*
Novel and Writer class

  Writer: first name, surname, year
    - method fullname

 Novel: name, year of release, author
    - authorAge
    - isWrittenBy(author)
    - copy (new year of release) = new instance of Novel
 */


/*
  Counter class
    - receives an int value
    - method current count
    - method to increment/decrement => new Counter
    - overload inc/dec to receive an amount
 */

class Writer(val firstName: String, val surname: String, val year: Int){
  def fullName: String = s"$firstName $surname"
}

class Novel(val name: String, val year: Int, val author: Writer){
  def authorAge: Int = this.year - this.author.year
  def isWrittenBy(author: Writer): Boolean = author == this.author
  def copy(newYear: Int): Novel = new Novel(this.name, newYear, this.author)
}

class Counter(val value: Int = 0 ){
  def currentCount(): Int = this.value // could be omitted
  def increment: Counter = {
    println("Incrementing...")
    new Counter(this.value + 1) // immutability
  }
  def decrement: Counter = {
    println("Decrementing...")
    new Counter(this.value - 1)
  }
  def increment(n: Int): Counter =
    if (n <= 0 ) this
    else increment.increment(n-1)

  def decrement(n: Int): Counter =
    if (n <= 0) this
    else decrement.decrement(n-1)

  def print = println(value)

}
