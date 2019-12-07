package lectures.part1basics

object StringOps extends App {

  val str: String = "Hello, I am learning Scala"

  // From Java
  println(str.charAt(2))
  println(str.substring(7, 11))
  println(str.split(" ").toList)
  println(str.startsWith("Hello"))
  println(str.replace(' ', '-'))
  println(str.toLowerCase)
  println(str.toUpperCase())
  println(str.length)

  val aNumberString = "2"
  val aNumber = aNumberString.toInt
  println('a' +: aNumberString :+ 'c')
  println(str.reverse)
  println(str.take(2))

  // From Scala - Interpolators

  // S-interpolators
  val name = "Raúl"
  val age = 15
  val greetings = s"Hi, my name is $name and I am $age years old"
  println(greetings)
  val anotherGreeting = s"Hi, my name is $name and I am ${age + 15} years old"
  println(anotherGreeting)

  // F-interpolators
  val speed = 1.2f
  val myth = f"$name%s can eat $speed%2.2f burgers per minute"
  println(myth)

  //raw-interpolator
  println(raw"This is a \n newline")
  val escaped = "This is a \n newline"
  println(raw"$escaped")


}
