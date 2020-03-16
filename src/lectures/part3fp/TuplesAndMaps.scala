package lectures.part3fp

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-03-15
 */

object TuplesAndMaps extends App{

  // Tuples
  // val aTuple = (2, "hello Scala!")
  val aTuple = Tuple2(2, "hello Scala!") // Tuple2[Int, String] = (Int, String)

  println(aTuple._1)
  println(aTuple.copy(_2 = "goodbye Java"))
  println(aTuple.swap)

  // Maps
  val aMap: Map[String, Int] = Map()

  val phoneBook = Map(("Jim", 555), "Raúl" -> 789).withDefaultValue(-1) // simple arrow: syntactic sugar
  println(phoneBook)

  // ops
  println(phoneBook.contains("Jim"))
  println(phoneBook("Jim"))
  println(phoneBook("Mary"))

  // add a pairing
  val newPairing = "Mary" -> 678
  val newPhoneBook = phoneBook + newPairing
  println(newPhoneBook)

  // functionals on maps

  println(phoneBook.map(pair => pair._1.toLowerCase -> pair._2))
  // filter keys and map values
  println(phoneBook.filterKeys(pair => pair.startsWith("J"))) // deprecated
  println(phoneBook.mapValues(x => x * 10)) // deprecated

  // conversions

  println(phoneBook.toList)
  println(List(("Raúl", 555)).toMap)
  val names = List("Raúl", "Palo", "Ramón", "Rebe")
  println(names.groupBy(x => x.charAt(0)))

  /*
  1 . What would happen in I had two original entries "Jim" -> 555 and "JIM" -> 900 and tolower
  2. Social network based on maps
  Person = String
  - add person
  - remove
  - friend/unfriend (mutual)

  Statistics
  - number of friends of a person
  - person with most friends
  - how many people have no friends
  - if there is a social connection between two people (direct or not)
   */
}
