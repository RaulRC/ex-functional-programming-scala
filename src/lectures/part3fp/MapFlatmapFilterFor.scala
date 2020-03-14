package lectures.part3fp

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-03-12
 */

object MapFlatmapFilterFor extends App{
  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map( _ + 1))
  println(list.map( _ + " is a number"))

  // filter
  println(list.filter( _ % 2 == 1 ))

  // flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.map(toPair))
  println(list.flatMap(toPair))

  val numbers = List(1,2,3,4)
  val characters = List('a', 'b', 'c', 'd')
  // List(a1, a2, ... , d4)
  val colors = List("black", "white")

  val combinations = numbers.filter(_ % 2 == 0).flatMap(n => characters.flatMap( c => colors.map(x => "" + c + n + x)))
  println(combinations)

  // foreach

  println(list.foreach(println))

  // for-comprenhensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0
    c <- characters
    x <- colors
  } yield "" + c + n + x

  println(forCombinations)

  // syntax overload
  list map { x => 2*x}

  /*
  1 - MyList support comprenhensions?
    - map(f: A => B: MyList[B]
    - filter(f: A => Boolean: MyList[A]
    - flatMap(f: A => MyList[B]: MyList[B])

  2 - A small collection of at most one element  - MayBe[+T]
    - map, flatmap, filter
   */

}
