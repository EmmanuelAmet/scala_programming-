class Person(val first:String, val last:String, age: Int = 4) {

  def printFullName(): Unit ={
    println(f"${this.first} ${this.last} is ${this.age} years old")
  }

  def this(f:String, l:String) = {this(f, l, 21)}

  def isAdult() : Unit = {
    if(this.age > 18)
      println("You're an adult")
    else
      println("You're a kid! :)")
  }

}
