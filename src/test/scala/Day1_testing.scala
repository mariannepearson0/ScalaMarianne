
class Day1_testing extends Base {

  "multiplyString function" should "multiply input string by 3" in {
    assert(Day1.multiplyString("hello",3) == "hellohellohello")
  }

  "printString2 function" should "return no string passed as default" in {
    assertResult("No string passed") {
      Day1.printString2()
    }
  }

  "returnAnything" should "return any type passed to it" in {
    assert(Day1.returnAnything(20).isInstanceOf[Int])
    assert(Day1.returnAnything("hello").isInstanceOf[String])
    assert(Day1.returnAnything(true).isInstanceOf[Boolean])
  }

  "endString function" should "throw an OutOfBoundsException" in {
    assertThrows[IndexOutOfBoundsException] {Day1.endString("hello", 100)}
  }

  "replaceString function" should "concatenate and replace" in {
    Day1.replaceString("Mar","ianne",'a','x') should equal ("Mxrixnne")
  }

  "formatDetails function" should "nicely format an input string" in {
    Day1.formatDetails("bob", "5 Cherrytree Lane") should be ("My name is BOB and I work at 5 cherrytree lane")
  }

  "formatNumber function" should "return input number to 3 decimal places as a string" in {
    Day1.formatNumber(34.590899828374) should equal ("34.591")
  }

  "revString function" should "return the string in reverse" in {
    assertResult("eonac"){Day1.revString("canoe")}
  }

  "addInts function" should "return the sum of the 2 passed numbers" in {
    Day1.addInts(10,30) should equal (40)
  }

  "ageInSeconds function" should "return the input age in seconds in a formatted string" in {
    Day1.ageInSeconds(1) should equal ("You are 1 years old, \nso your age in seconds is 31536000 seconds")
  }

  "booleanMath function" should "give different equations if boolean is true or false" in {
    Day1.booleanMath(10,20,true) should equal (30)
    Day1.booleanMath(10,20,false) should equal (200)
  }

  "whatIfZero function" should "give varying results depending on if one of tha values is zero" in {
    Day1.whatIfZero(0,0) should equal (0)
    Day1.whatIfZero(0,10) should equal (10)
    Day1.whatIfZero(15,0) should equal (15)
    Day1.whatIfZero(5,3) should equal (8)
  }

  "multiplePrint function" should "show that the message is printed" in {
    val loops = new Day1Class with MockOutput
    loops.multiplePrint("cat",3)
    loops.messages.mkString should equal ("catcatcat")
  }

  "rectangleString function" should "create a rectangle out of the given string" in {
    val loops = new Day1Class with MockOutput
    loops.rectangleString("H", 2)
    loops.messages should equal(List("HH","HH"))
  }

  "rectangleRecursive function" should "give the same result as rectangleString" in {
    val loops = new Day1Class with MockOutput
    loops.rectangleRec("H", 2,2)
    loops.messages should equal(List("HH", "HH"))
  }

  "fizzbuzz function" should "give the correct output for the fizzbuzz game" in {
    val loops = new Day1Class with MockOutput
    loops.fizzBuzz("fizz", "buzz", 15)
    loops.messages.mkString should equal("12fizz4buzzfizz78fizzbuzz11fizz1314fizzbuzz")
  }

  "fizzbuzzrec function" should "again give the correct output for the fizzbuzz game" in {
    val loops = new Day1Class with MockOutput
    loops.fizzBuzzRec("fizz", "buzz", 15)
    loops.messages.mkString should equal("12fizz4buzzfizz78fizzbuzz11fizz1314fizzbuzz")
  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }


}
