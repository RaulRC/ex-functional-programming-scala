package lectures.part3fp

import scala.util.Random

/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-03-18
 */

object Options extends App{

  val myFirstOption: Option[Int] = Some(4)
  val noOption: Option[Int] = None

  println(myFirstOption)
  println(noOption)

  // Work with unsafe APIs
  def unsafeMethod(): String = null

//  val result = Some(null) // WRONG
  val result = Option(unsafeMethod()) // Some or None

  println(result)

  // chained methods

  def backupMethod(): String = "A valid result"
  val chainResult = Option(unsafeMethod()).orElse(Option(backupMethod()))
  println(chainResult)

  // DESIGN unsafe APIs

  def betterUnsafeMethod(): Option[String] = None
  def betterBackupMethod(): Option[String] = Some("A valid result")

  val betterChainedResult = betterUnsafeMethod() orElse betterBackupMethod()

  println(betterChainedResult)

  // functions on Options
  println(myFirstOption.isEmpty)
  println(myFirstOption.get) // unsafe - do not use this

  // map, flatMap, filter
  println(myFirstOption.map(_ * 2))
  println(myFirstOption.filter( x => x > 10))
  println(myFirstOption.flatMap(x => Option(x * 10)))

  // for comprehensions
  /*
  Exercise.
   */

  val config: Map[String, String] = Map(
    // fetched from elsewhere
    "host" -> "176.45.36.1",
    "port" -> "80"
  )

  class Connection {
    def connect = "Connected" // connect to some server
  }
  object Connection {
    val random = new Random(System.nanoTime())

    def apply(host: String, port: String): Option[Connection] =
      if (random.nextBoolean()) Some(new Connection)
      else None
  }

  // try to establish a connection, if so - print the connect method

  val host = config.get("host") // option(string)
  val port = config.get("port") // option(string)

  val connection = host.flatMap(h => port.flatMap(p => Connection.apply(h, p)))
  val connectionStatus = connection.map(c => c.connect)
  connectionStatus.foreach(println)

  println("Short result")

  // Chained calls
  config.get("host")
    .flatMap(h => config.get("port")
      .flatMap(p => Connection.apply(h, p)))
    .map(connection => connection.connect)
    .foreach(println)

  // for-comprehensions

  val forConnectionStatus = for {
    host <- config.get("host")
    port <- config.get("port")
    connection <- Connection.apply(host, port)
  } yield connection.connect
  println("For-comprehensions")
  forConnectionStatus foreach println


}
