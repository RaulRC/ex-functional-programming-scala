package lectures.part2oop

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-11
 */

object InheritanceAndTraits extends App{

  // single class inheritance
  class Animal{
    val creatureType = "wild"
    //private def eat = println("nomnomonom")
    def eat = println("nomnomonom")
//    def eat = println("nomnomonom")
  }

  class Cat extends Animal{
    def crunch ={
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  // cannot using eat, because protected
  //cat.eat
  cat.crunch

  // CONSTRUCTORS
  class Person(name: String, age: Int){
    def this(name: String) = this(name, 0)
  }
//  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)
  class Adult(name: String, age: Int, idCard: String) extends Person(name)

  // overriding

  class Dog(override val creatureType: String) extends Animal{
//    override val creatureType: String = "domestic"
    override def eat = {
      super.eat
      println("Crunch, crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // type substitution (polymorphism)
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // super
  // preventing overrides
  // 1. final on members
  // 2. use final on the entire class
  // 3. seal the class = extend classes in THIS FILE, prevent extension in other files
  //    sealed class Animal ...
}
