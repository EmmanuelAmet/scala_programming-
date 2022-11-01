import java.util.Date

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