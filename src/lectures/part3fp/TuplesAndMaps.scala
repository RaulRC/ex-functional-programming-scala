package lectures.part3fp

import scala.annotation.tailrec

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

  //1.
  val myMap = Map(("Jim" -> 555), ("JIM" -> 900))
  println(myMap)
  println(myMap.groupBy(pair => pair._1.toLowerCase())) // convert to Hashmap with key and map
  val myMap2 = Map("jim" -> 555, "jim" -> 900)
  println(myMap2) // overlap values

  //2. Social network

  def add(network: Map[String, Set[String]], person: String): Map[String, Set[String]] =
    network + (person -> Set())

  def friend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA + b)) + (b -> (friendsB + a))
  }

  def unfriend(network: Map[String, Set[String]], a: String, b: String): Map[String, Set[String]] = {
    val friendsA = network(a)
    val friendsB = network(b)
    network + (a -> (friendsA - b)) + (b -> (friendsB - a))
  }

  def remove(network: Map[String, Set[String]], person: String): Map[String, Set[String]] = {
    def removeAux(friends: Set[String], networkAcc: Map[String, Set[String]]): Map[String, Set[String]] =
      if (friends.isEmpty) networkAcc
      else  removeAux(friends.tail, unfriend(networkAcc, person, friends.head))
    val unfriended = removeAux(network(person), network)
    unfriended - person
  }

  val empty: Map[String, Set[String]] = Map()
  val network = add(add(empty, "Bob"), "Mary")
  println(network)
  println(friend(network, "Bob", "Mary"))
  println(unfriend(friend(network, "Bob", "Mary"), "Bob", "Mary"))
  println(remove(friend(network, "Bob", "Mary"), "Bob"))

  // Jim, Bob, Mary

  val people = add(add(add(empty, "Bob"), "Mary"), "Jim")
  val jimBob = friend(people, "Bob", "Jim")
  val testNet = friend(jimBob, "Bob", "Mary")

  println(testNet)

  def nFriends(network: Map[String, Set[String]], person: String): Int =
    if (!network.contains(person)) 0
    else network(person).size

  println(nFriends(testNet, "Bob"))

  def mostFriends(network: Map[String, Set[String]]): String =
    network.maxBy(pair => pair._2.size)._1

  println(mostFriends(testNet))

  def nPeopleWithNoFriends(network: Map[String, Set[String]]): Int =
    // network.filterKeys(k => network(k).size == 0).size //deprecated
    // network.view.filterKeys(k => network(k).size == 0).size
    // network.filter(pair => pair._2.isEmpty).size // alternative
    network.count(pair => pair._2.isEmpty) // alternative

  println(nPeopleWithNoFriends(testNet))

  def socialConnection(network: Map[String, Set[String]], a: String, b: String): Boolean = {
    @tailrec
    def bfs(target: String, consideredPeople: Set[String], discoveredPeople: Set[String]): Boolean = {
      if (discoveredPeople.isEmpty) false
      else {
        val person = discoveredPeople.head
        if (person == target) true
        else if (consideredPeople.contains(person)) bfs(target, consideredPeople, discoveredPeople.tail)
        else bfs(target, consideredPeople + person, discoveredPeople.tail ++ network(person))
      }
    }
    bfs(b, Set(), network(a) + a)
  }

  println(socialConnection(testNet, "Mary", "Jim"))
  println(socialConnection(network, "Mary", "Bob"))


}
