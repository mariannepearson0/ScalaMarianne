package Garage

case class Bike(bikeRegNo:String, bikeParts:Array[Part], bikeTimeToFix:Int) extends Vehicle {

  val regNo:String = bikeRegNo
  val parts:Array[Part] = bikeParts
  val timeToFix:Int = bikeTimeToFix

  override def toString: String = {
    s"Registration Number:$regNo\nBike Parts: ${bikeParts.mkString}"
  }
}
