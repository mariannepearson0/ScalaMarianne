class Day2_testing extends Base {

  val Day2 = new Day2

  "booleanMathPattern function" should "alter equation when boolean is changed" in {
    Day2.booleanMathPattern(5,12,true) should equal (17)
    Day2.booleanMathPattern(5,12,false) should equal (60)
  }

  "whatIfZeroPattern function" should "return values based on parameters being zero" in {
    Day2.whatIfZeroPattern(12, 0) should equal(12)
    Day2.whatIfZeroPattern(0, 13) should equal(13)
    Day2.whatIfZeroPattern(0, 0) should equal(0)
    Day2.whatIfZeroPattern(5, 10) should equal(15)
  }

  "swapIntegers function" should "take a collection of 2 integers and swap them" in {
    Day2.swapIntegers(List(3,4)) should equal ("4, 3")
    Day2.swapIntegers(Array(3,4)) should equal ("4, 3")
    Day2.swapIntegers(Tuple2(3,4)) should equal ("4, 3")
  }
  it should "also take a collection of more than 2 integers and return the first 2 but not for tuples" in {
    Day2.swapIntegers(List(3,4,5,6,7)) should equal ("3, 4")
    Day2.swapIntegers(Array(3,4,5,6,7)) should equal ("3, 4")
    Day2.swapIntegers(Tuple5(3,4,5,6,7)) should equal ("invalid")
  }

  "integerListMapped val" should "give a subset of integerList which multiplies more than 20 by 10" in {
    Day2.integerListMapped should equal (List(2,16,7,8,250,3))
  }

  "stringListMapped val" should "give a subset of stringList but remove when length is 3 or less" in {
    Day2.stringListMapped.mkString should equal ("()pandamole()snake")
  }

  "flattenMap val" should "take a lists of lists and convert them into one list" in {
    Day2.flattenMap should equal (List(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20))
  }

  "biggestFruit function" should "return the biggest fruit from a list of fruit strings" in {
    Day2.biggestFruit should equal ("Strawberry")
  }



}
