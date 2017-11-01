class BigNumbers {

  def bigNumberConverter(number:String) = {
    var threesList = scala.collection.mutable.ListBuffer[String]()
    var startNumber = number.substring(0,number.length%3)
    if(startNumber != "") threesList += startNumber
    var newNumber = number.substring((number.length%3),number.length)
    var numArray = newNumber.toCharArray
    for(i <- 0 to numArray.length-3 by 3) {
      val first = numArray(i).toString + numArray(i + 1).toString + numArray(i + 2).toString
      threesList += first
    }
    threesList.reverse.toList
  }

  def makeSomeWords(bigNumberList: List[String]): String = {
    var shortScaleString = ""
    var longScaleString = ""
    for(i <- bigNumberList.length-1 to 0 by -1) {
      i match {
        case 0 => {shortScaleString += s"${bigNumberList(i)}"
          longScaleString += s"${bigNumberList(i)}"}
        case 1 => {shortScaleString += s"${bigNumberList(i)} thousand, "
          longScaleString += s"${bigNumberList(i)} thousand, "}
        case 2 => {shortScaleString += s"${bigNumberList(i)} million, "
          longScaleString += s"${bigNumberList(i)} million, "}
        case 3 => {shortScaleString += s"${bigNumberList(i)} billion, "
          longScaleString += s"${bigNumberList(i)} milliard, "}
        case 4 => {shortScaleString += s"${bigNumberList(i)} trillion, "
          longScaleString += s"${bigNumberList(i)} billion, "}
        case 5 => {shortScaleString += s"${bigNumberList(i)} quadrillion, "
          longScaleString += s"${bigNumberList(i)} billiard, "}
        case 6 => {shortScaleString += s"${bigNumberList(i)} quintillion, "
          longScaleString += s"${bigNumberList(i)} trillion, "}
        case 7 => {shortScaleString += s"${bigNumberList(i)} sextillion, "
          longScaleString += s"${bigNumberList(i)} trilliard, "}
        case _ => "none"
      }
    }
    s"Short Scale: $shortScaleString\nLong Scale: $longScaleString"
  }
}

