class Day3_testing extends Base {

  val day3 = new Day3

  "getCapitalsList function" should "return a list of all capitals from java's get TimeZone Ids" in {
    day3.getCapitalsList should contain inOrder ("Lusaka", "Malabo", "Maputo", "Maseru", "Mbabane")
  }

  "fibonnacci function" should "take a list of numbers and determine if they are a fibonnacci sequence" in {
    day3.fibonacci(List(1,1,2,3,5,8)) should equal (true)
    day3.fibonacci(List(33,5,2,78,3)) should equal (false)
  }

  "isAFactorial function" should "take a number and determine if it is a factorial of another number" +
    "if yes return the number, if no return NONE" in {
    day3.isAFactorial(120) should equal ("5!")
    day3.isAFactorial(121) should equal ("NONE")
  }

  "cipher function" should "convert a string to an encoded version where a=z, b=y etc etc" in {
    val loops = new Day3 with MockOutput
    loops.cipher("cat")
    loops.messages.mkString should equal("xzg")
  }

  "gcd function" should "find the greatest common divisor of 2 numbers" in {
    day3.gcd(12,6) should equal (6)
  }

  "calcFactorial function" should "calculate the factorial of a given number" in {
    day3.Calcfactorial(5) should equal (120)
  }

  "isInString function" should "check whether the first string passed is in the second string and give formatted output" in {
    day3.isInString("ha", "happy") should equal ("Yes indeed, ha is in happy")
    day3.isInString("he", "happy") should equal ("No in fact, he is not in happy")
  }

  "isInString2 function" should "take isInString as a function and return the same result. Example of higher order function" in {
    day3.isInString2(day3.isInString, "ha", "happy") should equal ("Yes indeed, ha is in happy")
    day3.isInString2(day3.isInString, "he", "happy") should equal ("No in fact, he is not in happy")
  }

  "isInString2 function" should "take an abstract function and does the same thing as isInString 1 and 2" in {
    day3.isInString2((str1: String, str2: String) => if (str2.contains(str1)) s"Yes indeed, $str1 is in $str2"
    else s"No in fact, $str1 is not in $str2", "ha", "happy") should equal ("Yes indeed, ha is in happy")
    day3.isInString2((str1: String, str2: String) => if (str2.contains(str1)) s"Yes indeed, $str1 is in $str2"
    else s"No in fact, $str1 is not in $str2", "he", "happy") should equal ("No in fact, he is not in happy")
  }

  "applyDiscounts function" should "take a value, if over 100 discount 10% then add 20% VAT" in {
    day3.applyDiscounts(150) should equal (162)
    day3.applyDiscounts(80) should equal (96)
  }

  "applyDiscountsCurried function" should "calculate the amount as quantity times price and then pass this value to the " +
    "applyDiscounts function using currying" in {
    day3.applyDiscountsCurried(2)(100)(day3.applyDiscounts) should equal (216)
  }

  "blackjack function" should "simulate the game of blackjack, given 2 numbers return closest to 21 without going over" in {
    day3.blackjack(21,5) should equal (21)
    day3.blackjack(25,7) should equal (7)
    day3.blackjack(0,0) should equal ("Invalid")
    day3.blackjack(28,30) should equal (0)
  }

  "uniqueSum function" should "take 3 numbers and return the sum of the unique ones, i.e if a number is repeated it is" +
    "not included in the sum" in {
    day3.uniqueSum(1,2,3) should equal (6)
    day3.uniqueSum(2,2,2) should equal (2)
    day3.uniqueSum(1,1,8) should equal (9)
  }

  "tooHot function" should "take a temperature and whether it is summer and if it falls between 60 and 90 in not summer" +
    "should return true in summer the range is changed from 60 to 100" in {
    day3.tooHot(80, false) should equal (true)
    day3.tooHot(100, false) should equal (false)
    day3.tooHot(100, true) should equal (true)
  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }

}
