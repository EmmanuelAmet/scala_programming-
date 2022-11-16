import java.util.Date
import java.util.concurrent.Future
import scala.concurrent.Future
import scala.concurrent.Future.never.recover
import scala.util.Try

object Main {
  def main(args: Array[String]): Unit = {
    val myValue = 100
    val z = {val a = 5; a + 3}
    println(s"The value is: $myValue")
    println(f"The value is: $z")
    println(raw"The value is: $z")
    val result = addOperation(4, 6)
    println(result)

    lazy val now = new Date().toString
    print(f"Current DataTime: $now")

    println(isEvenOddNumber(52))

    println(checksNumbers(333, 333))

    /* Match statement */
    val day = 39
    day match {
      case 1 => println("Monday")
      case 2 => println("Tuesday")
      case 3 => println("Wednesday")
      case 4 => println("Thursday")
      case 5 => println("Friday")
      case 6 => println("Saturday")
      case 7 => println("Sunday")
      case _ => println("Day unknown")
    }

    //While loop
    var number: Int = 5
    while( number <= 0){
      println("Hello there")
      number -= 1
    }

    for(a <- 1 to 5)
      println(f"Hello $a")

    val person = new Person("Emmanuel", "Amet", 7)
    person.printFullName()
    person.isAdult()


  }

  def addOperation(a:Int, b:Int): Int = {
    return a + b
  }

  def checksNumbers(first:Int, second:Int): String = {
    if(first > second){
      return (f"$first is greater than ${second}")
    }else if(first == second){
      return (f"$first is equal to $second")
    }else{
      return (f"$second is greater than $first")
    }
  }

  def isEvenOddNumber(number:Int) : String = {
    if(number % 2 == 0)
      return s"$number is even"
    else
      return f"$number is an odd number"
  }
}

object Application extends App{
  //Map
  val nameMap = Map("fName" -> "Emmanuel", "lName" -> "Amet", "age" -> 110)

  //FlatMap
  val names = Seq("Emmanuel", "Amet")
  val lNames = Seq("Amet")
  println(names.flatMap(_.toUpperCase()))

  //Filter
  val numbers = List(1,2,3,4,5,6,7,8)
  val filter = numbers.filter(_ > 5)
  println(filter)

  //Partition
  val list1 = List(1,2,3,4,5,6)
  val part1 = list1.partition(_ > 2)
  println(part1)

  //Zip
  val list2 = List(1,2,3,4,5)
  val list3 = List(6,7,8,9,0)
  val zip = list2.zip(list2)
  println(zip)

  //Foreach
  val list4 = List(1,2,3,4,5,6)
  list4 foreach(println)

  for (x <- list4) yield println(x + 2)

  //Options
  def partn(str: Option[String]) = str match {
    case Some(s) => s
    case None => ("Key not found")
  }

  val days = Map("one" -> "Monday", "two" -> "Tuesday")
  println(partn(days.get("one")))

  val countries = List("Ghana", "UK", "USA")
  val capitals = Map("Ghana" -> "Accra", "UK" -> "London", "USA" -> "Washington DC")
  val flat = countries flatMap(c => capitals.get(c))
  val token: Option[String] = None
  println(flat)

  for(c <- countries; cap <- capitals.get(c)) yield println((c, cap))

  def computeDivision(a:Int, b:Int): Either[String, Double] = {
    if(a == 0) return Left("Division impossible")
    Right(a / b)
  }

  def computeDivision2(a: Int, b:Int): Double = {
    a / b
  }

  println(computeDivision(9, 4))

  //Try catch
  try{
    println(computeDivision2(99, 0))
  }catch {
    case e: ArithmeticException => println("Arithmetic Exception")
    case _ => println("Error")
  }

  val num = "111"
//  Try (num.toInt)
//  recover{
//    case e => "Error"
//  }


  def passedByValue(a: Int) = a *a
  def passedByName(a: => Int) = a * a

  println(passedByName(2))
  println(passedByValue(2))

  //Curried
  def add(a: Int)(b:Int): Int = {
    a * b
  }

  println(add(2)(5 + 4))

  //Partially define func
  val pf: PartialFunction[Int, String] = {
    case 1 => "One"
    case 2 => "Two"
    case 3 => "Three"
  }

  println(pf isDefinedAt(5))
  println(pf(2))
}

object SquareRoot extends PartialFunction[Int, Double] {
  override def isDefinedAt(x: Int) = (x >= 1)

  override def apply(v1: Int) = if(v1 >= 0) Math.sqrt(v1) else
    throw new IllegalArgumentException("")
}

