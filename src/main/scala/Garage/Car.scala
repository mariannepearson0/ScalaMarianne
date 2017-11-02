package Garage

case class Car(carRegNo:String, carMake:String, carParts:Array[Part], carTimeToFix:Double=0) extends Vehicle {

  val regNo:String = carRegNo
  val parts:Array[Part] = carParts
  var timeToFix:Double = carTimeToFix

  override def toString: String = {
    s"Registration Number: $regNo\nCar Make: $carMake\nCar parts: ${carParts.mkString}"
  }
}
