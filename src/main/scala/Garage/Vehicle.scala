package Garage

abstract class Vehicle{
  val regNo:String
  val parts:Array[Part]

  def totalTimeToFix: Double = {
    var totalTime: Double = 0
    for (part <- parts if part.broken == true) {
      totalTime += part.timeToFix(part.partType)
    }
    totalTime
  }
}
