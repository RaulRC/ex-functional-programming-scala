package lectures.part2oop

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-11
 */

object AbstractDataTypes extends App{

  //abstract
  abstract class Animal{
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  //traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  trait ColdBlooded

  class Crocodile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = "nomnomnom"
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Crocodile
  croc.eat(dog)

  // traits vs abstract classes
  // both abstract classes and traits can have abstract and non abstract members
  // 1. traits do not have constructors parameters
  // 2. multiple traits may be inherited by the same class
  // 3. traits = behavior, abstract class = type of thing


  /*
  *
  *    Any
  *       AnyRef (String, List, Set, ...)
  *         Null
  *       AnyVal (Int, Unit, Boolean
  *
  *
  *        Nothing (subtype of every thing in Scala)
  *
  *
  *
  *
  *
  *
  *
   */

}
