
object Day1 {

  //Basic Exercises

  //HELLO WORLD!
  println("Hello World!")

  //ASSIGNMENT
  var hello = "Hello World!"
  println(hello)

  //REASSIGNMENT
  hello = "Hello another world!"
  println(hello)

  //PARAMETERS
  def printString(message:String) = println(message)

  //printString("Hello world")

  //PARAMETERS 2
  def printString2(message:String = "No string passed") = message

  //printString2()
  //printString2("Hello world")

  //PARAMETERS 3
  def multiplyString(message:String, multiply:Int = 1) = message * multiply

//  multiplyString("Hello",3)
//  multiplyString(multiply=4, message="Hello")

  //RETURN TYPES
  def returnString(message:String): String = message

  //println(returnString("Hello World!"))

  //TYPE INFERENCE
  def returnAnything(thing:Any) = thing

//  println(returnAnything(567))
//  println(returnAnything("something"))
//  println(returnAnything(true))

  //STRINGS
  def endString(message:String, amount:Int) = message.substring(message.length-amount, message.length)

  //println(endString("Hello",3))

  //STRINGS 2
  def replaceString(start:String, end:String, toReplace:Char, replaceBy:Char) = {
    (s"$start$end").replace(toReplace, replaceBy)
  }

  //println(replaceString("Ha", "llo", 'a', 'e'))

  //STRINGS 3
  def formatDetails(name:String, address:String) = {
    s"My name is ${name.toUpperCase} and I work at ${address.toLowerCase}"
  }

  //formatDetails("Marianne Pearson", "5th Floor, Disneyland Paris, YU56GHT")

  //STRINGS 4
  def formatNumber(number:Double) = f"${number}%.3f"
  //formatNumber(145.789776785)

  //STRINGS 5
  def revString(message:String) = message.reverse

  //revString("wonderful")

  //OPERATORS
  def addInts(int1:Int, int2:Int): Int = int1 + int2

  //println(addInts(5,9))

  //OPERATORS2
  def ageInSeconds(age:Int) = f"You are $age years old, \nso your age in seconds is ${age*365*24*60*60} seconds"

  //ageInSeconds(20)

  //CONDITIONALS
  def booleanMath(int1: Int, int2: Int, bool: Boolean) = {
    if (bool == true) int1 + int2
    else int1 * int2
  }

//  booleanMath(30, 4, true)
//  booleanMath(30, 4, false)

  //CONDITIONALS 2
  def whatIfZero(int1: Int, int2: Int) = {
    if (int1 == 0) int2
    else if (int2 == 0) int1
    else if (int1 == 0 && int2 == 0) 0
    else int1 + int2
  }

//  println(whatIfZero(0,9))
//  println(whatIfZero(5,0))
//  println(whatIfZero(0,0))
//  println(whatIfZero(4,7))

  //ITERATION
  def multiplePrint(message:String, number: Int) = {
    for (i <- 0 to number) println(message)
  }

  //multiplePrint("Marianne", 5)

  //ITERATION 3
  def rectangleString(message:String, num:Int)= {
    for (i <- 0 to num){
      println(message * num)
    }
  }
  //rectangleString("H",4)

  //ITERATION 3 RECURSIVE
  def multiplePrintRec(message:String, number: Int, counter:Int) : Unit = {
    if(counter >= 0) {
      println(message * number)
      multiplePrintRec(message, number, counter - 1)
    }
  }

  //multiplePrintRec("H",4, 4)

  //FIZZBUZZ
  val mod3 = (i:Int) => i%3
  val mod5 = (i:Int) => i%5

  def fizzBuzz(fizz: String, buzz: String, range:Int) = {
    for (i <- 0 to range){
      if (mod3(i) == 0 && mod5(i) == 0) println(s"$fizz$buzz")
      else if (mod3(i) == 0) println(fizz)
      else if (mod5(i) == 0) println(buzz)
      else println(i)
    }
  }
  //fizzBuzz("fizz", "buzz", 20)

  //FIZZBUZZ iterative
  def fizzBuzzRec(fizz: String, buzz: String, range:Int, counter:Int = 0) : Unit = {
    if (counter <= range) {
      if (mod3(counter) == 0 && mod5(counter) == 0) println(s"$fizz$buzz")
      else if (mod3(counter) == 0) println(fizz)
      else if (mod5(counter) == 0) println(buzz)
      else println(counter)
      fizzBuzzRec(fizz, buzz, range, counter + 1)
    }
  }
  //fizzBuzzRec("fizz", "buzz", 20)

}
