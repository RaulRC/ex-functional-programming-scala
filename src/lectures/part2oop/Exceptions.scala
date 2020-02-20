package lectures.part2oop

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-20
 */

object Exceptions extends App{

  // 1. Throwing exceptions
  val x: String = null
  // println(x.length) // null pointer exception

  // val aWeirdValue = throw new NullPointerException // returns Nothing

  // throwable classes extend the Throwable class
  // Exceptions and Error are the major Throwable

  // 2. how to catch
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No int for you!")
    else 42

  val potentialFail = try {
    // code that might throw
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally {
    // code that will get executed NO MATTER WHAT
    // Optional and do not influence the return type of this expression
    // use finally only for side effects
    println("Finally")

    // 3. how to define your own exceptions

    class MyException extends Exception
    val exception = new MyException

    throw exception
  }

  println(potentialFail)

}
