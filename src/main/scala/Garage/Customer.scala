package Garage

case class Customer(customerName:String, customerAge:Int, customerAddress:String, dateOfIssue:String) extends Person {

  def name: String = customerName
  def age: Int = customerAge
  def address: String = customerAddress

  override def toString :String = {
    s"Name:$name\nAge: $age\nAddress: $address\nDate of Issue: $dateOfIssue"
  }
}
