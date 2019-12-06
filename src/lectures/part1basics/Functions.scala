package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  // Can be called without paretheses
  def aParameterlessFunction(): Int = 42

  println(aParameterlessFunction)

  // Recursive functions need return type (as good practice, always)
  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  // When you need loops, use recursion

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b

    aSmallerFunction(n, n-1)
  }

  // Exercises
  // 1. Greeting function

  def greetings(name: String, age: Int): String = "Hi, my name is " + name + " and I'm " + age + " years old."
  println(greetings("Raúl", 15))

  // 2. Factorial of n

  def factorial(n: Int): Int = if (n <= 0) 1 else n * factorial(n-1)
  println(factorial(5))

  // 3. Fibonacci

  def fibonacci(n: Int): Int = if (n<=2) 1 else fibonacci(n-1) + fibonacci(n-2)
  println(fibonacci(8))

  // 4. Prime numbers
  def isPrime(n: Int): Boolean = {
    def isDivisibleBy(a: Int, b: Int): Boolean = {
      if (b > 1) (a % b == 0) || isDivisibleBy(a, b-1) else false
    }
    !isDivisibleBy(n, n-1)
  }

  // 4. Prime numbers (prof corrected
  def isPrimeCorrected(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true else n % t != 0 && isPrimeUntil(t-1)

    isPrimeUntil(n/2)
  }

  println(isPrime(2003))
  println(isPrimeCorrected(2003))
  println(isPrime(37 * 17))

}
