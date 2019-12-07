package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n -1, acc * n)

  println(trFact(10))

  def saveFig(format: String = "jpg", h: Int = 1920, w: Int = 1080 ): Unit = println("Saving figure")

  // Naming parameters during invocation
  saveFig(format = "jpg", w = 100)
}
