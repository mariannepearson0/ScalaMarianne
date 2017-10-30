package Garage

case class Car(carRegNo:String, carMake:String, carParts:Array[Part], carTimeToFix:Int) extends Vehicle {

  val regNo:String = carRegNo
  val parts:Array[Part] = carParts
  val timeToFix:Int = carTimeToFix

  override def toString: String = {
    s"Registration Number: $regNo\nCar Make: $carMake\nCar parts: ${carParts.mkString}"
  }
}
