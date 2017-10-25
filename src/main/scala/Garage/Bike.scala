package Garage

class Bike(regNo:Int, faults:Int) extends Vehicle(regNo, faults) {

  override def toString = {
    s"The bike registration number is $regNo, there are $faults faults"
  }
}
