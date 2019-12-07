package lectures.part1basics

import scala.annotation.tailrec

object Recursion extends App {

  def factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n-1)

  def anotherFactorial(n: Int): BigInt = {
    @tailrec
    def factHelper(x: Int, accumulator: BigInt): BigInt =
      if (x <= 1) accumulator else factHelper(x -1 , x * accumulator) // TAIL RECURSION
    /*
    Tail recursion: use the recursion call as the LAST expression
    Use every time you  need loops
     */

    factHelper(n, 1)
  }

  println(anotherFactorial(9000))

  // Exercises - Tail recursion

  // 1. Concatenate string n times

  def concatenateTail(s: String, n: Int): String = {
    def concatHelper(x: String, t: Int, accumulator: String): String =
      if (t <=1) accumulator else concatHelper(x, t-1, x + accumulator)
    concatHelper(s, n, "")
  }

  println(concatenateTail("hello", 5000))

  // 2. Prime numbers tailrec

  def isPrimeTail(n: BigInt): Boolean = {
    @tailrec
    def isDivisibleBy(a: BigInt, b: BigInt): Boolean =
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    !isDivisibleBy(n, n/2)
  }

  println(isPrimeTail(BigInt("2003")))

  // Prof Corrected
  def isPrimeCorrected(n: BigInt): Boolean = {
    def isStillPrime(t: BigInt, accumulator: Boolean): Boolean ={
      if (! accumulator) false
      else if (t <= 1) true
      else isStillPrime(t-1, n % t != 0 && accumulator)
    }
    isStillPrime(n/2, true)
  }


  println(isPrimeCorrected(BigInt("2003")))

  // 3. Fibonacci

  def fibonacci(n: BigInt): BigInt = {
    def fibonacciHelper(i: BigInt, last: BigInt, nextLast: BigInt): BigInt =
      if (i == n) last else fibonacciHelper(i + 1, last + nextLast, last)
    fibonacciHelper(2, 1, 1)
  }

  println(fibonacci(200)) // 1 1 2 3 5 8 13 21

}
