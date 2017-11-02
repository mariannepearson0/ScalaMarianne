package Garage

case class Employee(salary:Int, employeeName:String, employeeAge:Int, employeeAddress:String, var active:Boolean=false, var regWork:String) extends Person {

  def name:String = employeeName
  def age:Int = employeeAge
  def address:String = employeeAddress

  override def toString:String = {
    s"Name: $name\nAge: $age\nAddress: $address\nSalary:$salary"
  }
}
