package lectures.part3fp

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-03-10
 */

object AnonymousFunctions extends App{

  // anonymous function (LAMBDA)
  def doubler: Int => Int = (x) => x * 2
  println(doubler(4))

  // multiple parameters
  def adder: (Int, Int) => Int = (a, b)=> a+b

  // no params

  def justNothing: () => Int = () => 3

  println(justNothing)
  println(justNothing())

  // Curly braces with Lambda
  val stringToInt = { (str: String) =>
    str.toInt
  }

  // Syntactic sugar

  val niceIncrement: Int => Int = _ + 1 // equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // equivalent to (a, b) => a+b
  println(niceAdder(3,5))


  /*
  1. MyList: replace all functionX with lambdas
  2. Rewrite the "special" adder as an anonymous function
   */

  val superAdd = (x: Int) => (y: Int) => x + y
  println(superAdd(3)(4))
}
