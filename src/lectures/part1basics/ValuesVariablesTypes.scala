package lectures.part1basics

object ValuesVariablesTypes extends App {

  val x: Int = 42
  println(x)

  // Vals are inmutable
  // Compiler can infer types

  val aString: String = "Hello"
  val anotherString = "Goodbye"

  val aBoolean: Boolean = true
  val aChar: Char = 'a'
  val anInt: Int = x // Bytes
  val aShort: Short = 4433 // 2 Bytes instead of 4
  val aLong: Long = 4433221142242L // 8 Bytes instead of 4
  val aFloat: Float = 2.0f // without f is a Double
  val aDouble: Double = 3.14

  // variables
  var aVariable: Int = 4

  aVariable = 5 // side effects
}
