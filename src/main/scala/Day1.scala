trait Output {
  def print(s: String) = Console.println(s)
}

class Day1 extends Output {

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

  //PARAMETERS 2
  def printString2(message:String = "No string passed") = message

  //PARAMETERS 3
  def multiplyString(message:String, multiply:Int = 1) = message * multiply

  //RETURN TYPES
  def returnString(message:String): String = message

  //TYPE INFERENCE
  def returnAnything(thing:Any) = thing

  //STRINGS
  def endString(message:String, amount:Int) = message.substring(message.length-amount, message.length)

  //STRINGS 2
  def replaceString(start:String, end:String, toReplace:Char, replaceBy:Char) = {
    (s"$start$end").replace(toReplace, replaceBy)
  }


  //STRINGS 3
  def formatDetails(name:String, address:String) = {
    s"My name is ${name.toUpperCase} and I work at ${address.toLowerCase}"
  }

  //STRINGS 4
  def formatNumber(number:Double) = f"${number}%.3f"

  //STRINGS 5
  def revString(message:String) = message.reverse

  //OPERATORS
  def addInts(int1:Int, int2:Int): Int = int1 + int2

  //OPERATORS2
  def ageInSeconds(age:Int) = f"You are $age years old, \nso your age in seconds is ${age*365*24*60*60} seconds"

  //CONDITIONALS
  def booleanMath(int1: Int, int2: Int, bool: Boolean) = {
    if (bool == true) int1 + int2
    else int1 * int2
  }

  //CONDITIONALS 2
  def whatIfZero(int1: Int, int2: Int) = {
    if (int1 == 0) int2
    else if (int2 == 0) int1
    else if (int1 == 0 && int2 == 0) 0
    else int1 + int2
  }

  //ITERATION
  def multiplePrint(message:String, number: Int) = {
    for (i <- 0 until number) print(message)
  }

  //ITERATION 3
  def rectangleString(message:String, num:Int)= {
    for (i <- 0 until num){
      print(message * num)
    }
  }

  //ITERATION 3 RECURSIVE
  def rectangleRec(message:String, number: Int, counter:Int) : Unit = {
    if(counter > 0) {
      print(message * number)
      rectangleRec(message, number, counter - 1)
    }
  }

  //FIZZBUZZ
  val mod3 = (i:Int) => i%3
  val mod5 = (i:Int) => i%5

  def fizzBuzz(fizz: String, buzz: String, range:Int) = {
    for (i <- 1 to range){
      if (mod3(i) == 0 && mod5(i) == 0) print(s"$fizz$buzz")
      else if (mod3(i) == 0) print(fizz)
      else if (mod5(i) == 0) print(buzz)
      else print(i.toString)
    }
  }

  //FIZZBUZZ iterative
  def fizzBuzzRec(fizz: String, buzz: String, range:Int, counter:Int = 1) : Unit = {
    if (counter <= range) {
      if (mod3(counter) == 0 && mod5(counter) == 0) print(s"$fizz$buzz")
      else if (mod3(counter) == 0) print(fizz)
      else if (mod5(counter) == 0) print(buzz)
      else print(counter.toString)
      fizzBuzzRec(fizz, buzz, range, counter + 1)
    }
  }
}
