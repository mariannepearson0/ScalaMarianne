object Day2 {

  //PATTERN MATCHING 1
  def booleanMathPattern(int1:Int, int2:Int, bool:Boolean) = {
    (int1, int2, bool) match {
      case (_,_,true) => int1+int2
      case (_) => int1*int2
    }
  }

  booleanMathPattern(5,7,false)

  //PATTERN MATCHING 1
  def whatIfZeroPattern(int1:Int, int2:Int) = {
    List(int1, int2) match {
      case x::xs if int1 == 0 => int2
      case x::xs if int2 == 0 => int1
      case x::xs if int1 == 0 && int2 == 0 => 0
      case _ => int1 + int2
    }
  }

  println(whatIfZeroPattern(0,9))
  println(whatIfZeroPattern(5,0))
  println(whatIfZeroPattern(0,0))
  println(whatIfZeroPattern(4,7))

  //PATTERN MATCHING 2
  def swapIntegers(numbers: Any) = {
    numbers match {
      case List(int1, int2) => println(s"$int2, $int1")
      case Array(int1, int2) => println(s"$int2, $int1")
      case Tuple2(int1, int2) => println(s"$int2, $int1")
      case x::xs => List(x,xs(0))
      case Array(x,x1,_*) => Array(x,x1)
      case _ => "invalid"
    }
  }

  swapIntegers(List(3,4))
  swapIntegers(Array(3,4))
  swapIntegers(Tuple2(3,4))
  swapIntegers(List(3,4,5,6))
  swapIntegers(Array(4,5,6,7))

  //MAP FUNCTION 1
  val integerList = List(2,16,7,8,25,3)
  integerList.map(num => if (num > 20) num * 10 else num)

  //MAP FUNCTION 2
  val stringList = List("cat", "panda", "mole", "bat", "snake")
  //Leaves gaps where cat and bat are removed
  stringList.map(animal => if (animal.length >= 4) animal)

  //FLATMAP FUNCTION
  val lotsOfLists = List(List(List(1,2,3,4,5), List(6,7,8,9,10)),
    List(List(11,12,13,14,15), List(16,17,18,19,20)))

  lotsOfLists.flatMap(_.toList).flatMap(_.toList)

  //FOREACH 1
  val foodList = List("pineapple", "quorn", "yoghurt", "potato", "biscuits")
  foodList foreach println

  //FOREACH 2
  val fruitList = List("Apple", "Raspberry", "Lemon", "Kiwi", "Strawberry")
  var bigFruit = ""
  fruitList foreach (fruit => if (fruit.length > bigFruit.length) bigFruit = fruit)
  println(bigFruit)

}
