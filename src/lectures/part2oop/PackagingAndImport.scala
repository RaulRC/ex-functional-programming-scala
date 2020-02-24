package lectures.part2oop
                  // alias for naming clonflict
import playground.{Cinderella => Princess, PrinceCharming}
import java.util.Date
import java.sql.{Date => sqlDate}
/*
 * @project ex-functional-programming-scala
 * @author raul.reguillo on 2020-02-21
 */

object PackagingAndImport extends App{

  // package memgers are accesible by their simple name
  val writer =new Writer("Daniel", "RockTheJVM", 2018)

  // import the package
  val princess = new Princess // playground.Cinderella = fully qualified name

  // packages are in hierarchy
  // matching folder structure

  // package object
  sayHello
  println(SPEED_OF_LIGHT)

  // imports
  val prince = new PrinceCharming

  val date = new Date
  val sqlDate = new sqlDate(2018, 5, 4)
  // use aliasing


}
