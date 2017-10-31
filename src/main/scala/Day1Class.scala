trait Output {
  def print(s: String) = Console.println(s)
}

class Day1Class extends Output {

  //ITERATION
  def multiplePrint(message:String, number: Int) = {
    for (i <- 0 until number) print(message)
  }

  //multiplePrint("Marianne", 5)

  //ITERATION 3
  def rectangleString(message:String, num:Int)= {
    for (i <- 0 until num){
      print(message * num)
    }
  }
  //rectangleString("H",4)

  //ITERATION 3 RECURSIVE
  def rectangleRec(message:String, number: Int, counter:Int) : Unit = {
    if(counter > 0) {
      print(message * number)
      rectangleRec(message, number, counter - 1)
    }
  }

  //multiplePrintRec("H",4, 4)

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
  //fizzBuzz("fizz", "buzz", 20)

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
  //fizzBuzzRec("fizz", "buzz", 20)

}
