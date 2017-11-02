class BigNumbers {

  def bigNumberConverter(num:BigInt) = {
    val number = num.toString
    val startNumber = number.substring(0,number.length%3)
    var threesList = scala.collection.mutable.ListBuffer[String]()
    if(startNumber != "") threesList += startNumber
    val newNumber = number.substring(number.length%3,number.length)
    val numArray = newNumber.toCharArray
    for(i <- 0 to numArray.length-3 by 3) {
      threesList += numArray(i).toString + numArray(i + 1).toString + numArray(i + 2).toString
    }
    threesList.reverse.toList
  }

  def makeSomeWords(bigNumberList: List[String], counter:Int = 0):Any = {
    if(counter == 0) print("Short Scale: ")
    else if(counter == 1) print("Long Scale: ")
    else System.exit(0)
    for(i <- bigNumberList.length-1 to 0 by -1) {
      i match {
        case 0 => println(s"${bigNumberList(i)}")
        case 1 => print(s"${bigNumberList(i)} thousand, ")
        case 2 => print(s"${bigNumberList(i)} million, ")
        case 3 if counter == 0 => print(s"${bigNumberList(i)} billion, ")
        case 3 if counter == 1 => print(s"${bigNumberList(i)} milliard, ")
        case 4 if counter == 0 => print(s"${bigNumberList(i)} trillion, ")
        case 4 if counter == 1 => print(s"${bigNumberList(i)} billion, ")
        case 5 if counter == 0 => print(s"${bigNumberList(i)} quadrillion, ")
        case 5 if counter == 1 => print(s"${bigNumberList(i)} billiard, ")
        case 6 if counter == 0 => print(s"${bigNumberList(i)} quintillion, ")
        case 6 if counter == 1 => print(s"${bigNumberList(i)} trillion, ")
        case 7 if counter == 0 => print(s"${bigNumberList(i)} sextillion, ")
        case 7 if counter == 1 => print(s"${bigNumberList(i)} trilliard, ")
        case _ => "none"
      }
    }
    makeSomeWords(bigNumberList, counter+1)
  }
}

