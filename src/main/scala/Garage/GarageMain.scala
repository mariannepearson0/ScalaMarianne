package Garage

object GarageMain extends App {

  val myGarage = new Garage()
  val myParts = new Part(true, "")

  val Jerry = new Customer("Jerry", 34, "5 Pleasance Drive", "26/10/2017")

  val JerryCar = new Car("XF567JU", "Toyota", myParts.partArray(10))
  val Harrison = new Customer("Harrison", 29, "63 Honeycomb Avenue", "23/10/2017")
  val HarrisonCar = new Car("G8J9OLE", "Toyota", myParts.partArray(10))
  val Penelope = new Customer("Penelope", 19, "18 Crescent Lane", "21/10/2017")
  val PenelopeCar = new Bike("HY562HH", myParts.partArray(10))
  val Kieran = new Employee(25000, "Kieran", 41, "5 Lovelace Lane", false, "")

  myGarage.addVehicle(Jerry, JerryCar)
  myGarage.addVehicle(Harrison, HarrisonCar)
  myGarage.addVehicle(Penelope, PenelopeCar)
  //myGarage.fixVehicle("HY562HH")


  myGarage.outputContents()
  myGarage.removeVehicle("XF567JU")
  myGarage.outputContents()

  myGarage.registerEmployee(Kieran)
  println(myGarage.employeeList)

  myGarage.calculateBill("HY562HH")
}
