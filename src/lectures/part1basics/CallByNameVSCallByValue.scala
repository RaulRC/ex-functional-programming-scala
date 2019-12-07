package lectures.part1basics

object CallByNameVSCallByValue extends App{


  def callByValue(x: Long): Unit = {
    println("By value: " + x)
    println("By value: " + x)
  }

  // Lazy evaluation
  def callByName(x: => Long): Unit = {
    println("By name: " + x)
    println("By name: " + x)
  }

  callByValue(System.nanoTime())
  callByName(System.nanoTime())

  def infinite(): Int = 1 + infinite()
  def anyFunction(x: Int, y: => Int): Unit = println(x)

  // this crash
//  anyFunction(infinite(), 42)
  // this does not
  anyFunction(42, infinite())

}
