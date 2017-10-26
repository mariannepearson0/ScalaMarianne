package Garage

case class Bike(bikeRegNo:String, bikeFaults:Map[String,Int]) extends Vehicle {

  val regNo:String = bikeRegNo
  var faults:Map[String,Int] = bikeFaults

  override def toString: String = {
    s"Registration Number:$regNo\nFaults: $faults"
  }
}
