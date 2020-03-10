package exercises

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-11
 */

abstract class MyList[+A]{

  /*
  head = first element
  tail = remainder of the list
  isEmpty = is this list empty
  add(int) => new list with this element added
  toString => a string representation of the list
   */

  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](element: B): MyList[B]
  def printElements: String
  override def toString: String = "["+ printElements +"]"

  // Higher-order functions
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]
  def filter(predicate: A => Boolean): MyList[A]

  def ++[B >: A](list: MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty: Boolean = true
  def add[B >: Nothing](element: B): MyList[B] = new Cons(element, Empty)
  override def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  def ++ [B >: Nothing](list: MyList[B]): MyList[B] = list

}

case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  def head: A = h
  def tail: MyList[A] = t
  def isEmpty: Boolean = false
  def add[B >: A](element: B): MyList[B] = new Cons(element, this)

  def printElements: String =
    if(t.isEmpty) "" + h
    else h + " " + t.printElements

  def map[B](transformer: A => B): MyList[B] =
    new Cons(transformer(h), t.map(transformer))


  def ++ [B >: A](list: MyList[B]): MyList[B] = new Cons(h, t ++ list)

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def filter(predicate: A => Boolean): MyList[A] =
    if (predicate(head)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)



}

object ListTest extends App {
  val listOfIntegers : MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))
  val cloneListOfIntegers : MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))

  val listOfStrings : MyList[String] = new Cons("hello", new Cons("Scala", Empty))

  println(listOfIntegers.toString)
  println(listOfStrings.toString)

  val anotherListOfIntegers : MyList[Int] = new Cons(1, new Cons(2, new Cons(3, Empty)))

  println((listOfIntegers ++ anotherListOfIntegers))
  println(listOfIntegers.flatMap(elem => new Cons(elem, new Cons(elem + 1, Empty))).toString)


  // case class
  println(cloneListOfIntegers == listOfIntegers)
}


