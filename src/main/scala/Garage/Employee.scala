package Garage

class Employee(salary:Int, name:String, age:Int, address:String) extends Person(name, age, address) {

  override def toString = {
    s"The persons name is $name, their age is $age, their address is $address their salary is $salary"
  }
}
