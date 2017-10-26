package Garage

case class Car(carRegNo:String, carFaults:Map[String,Int], carMake:String) extends Vehicle {

  val regNo:String = carRegNo
  var faults:Map[String,Int] = carFaults

  override def toString: String = {
    s"Registration Number: $regNo\nCar Make: $carMake\nNumber of Faults: $faults"
  }
}
