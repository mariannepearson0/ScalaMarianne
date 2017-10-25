package Garage

class Customer(name:String, age:Int, address:String, dateOfIssue:String) extends Person(name, age, address) {

  override def toString = {
    s"The persons name is $name, their age is $age, their address is $address the date the car came into the garage is $dateOfIssue"
  }
}
