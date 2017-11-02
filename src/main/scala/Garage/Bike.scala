package Garage

case class Bike(bikeRegNo:String, bikeParts:Array[Part], bikeTimeToFix:Double=0) extends Vehicle {

  val regNo:String = bikeRegNo
  val parts:Array[Part] = bikeParts
  var timeToFix:Double = bikeTimeToFix

  override def toString: String = {
    s"Registration Number:$regNo\nBike Parts: ${bikeParts.mkString}"
  }
}
