package Garage

case class Part(broken:Boolean, partType:String) {
  val random = scala.util.Random
  var broke: Boolean = false
  val partTypeArray = Array[String]("tyre", "windscreen", "bumper", "boot", "windscreen wipers", "engine", "flux capacitor")

  def selectPart (partT: String):Part  = {
    val numb = random.nextInt(2)
    if(numb == 0) broke = true
    else if (numb == 1) broke = false
    new Part(broke, partT)
  }

  def partArray(numberOfParts:Int): Array[Part] = {
    val partArray = new Array[Part](numberOfParts)
    for(i <- 0 to numberOfParts -1) {
      partArray(i) = selectPart(partTypeArray(random.nextInt(7)))
    }
    partArray
  }
}
