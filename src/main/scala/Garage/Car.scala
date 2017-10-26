package Garage

class Car(regNo:Int, faults:Int, make:String) extends Vehicle(regNo, faults) {

  override def toString = {
    s"The car registration number is $regNo, the make of the car is $make there are $faults faults"
  }
}
