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

  def timeToFix(partType:String): Double = {
    var timeToFix:Double = 0
    partType match {
      case "tyre" => timeToFix += 0.5
      case "windscreen" => timeToFix += 0.75
      case "bumper" => timeToFix += 0.25
      case "boot" => timeToFix += 1
      case "windscreen wipers" => timeToFix += 0.4
      case "engine" => timeToFix += 3
      case "flux capacitor" => timeToFix += 10
      case _ => 0
    }
    timeToFix
  }
}
