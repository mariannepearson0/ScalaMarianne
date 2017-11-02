package Garage

class Garage {

    var employeeList = scala.collection.mutable.ListBuffer.empty[Employee]
    var customerMap = scala.collection.mutable.Map.empty[Customer,Vehicle]
    var garageIsOpen = false

    def addVehicle(customer:Customer, vehicle:Vehicle) = {
      customerMap(customer) = vehicle
      println(s"The vehicle for ${customer.name} has been added.")
    }

    def keyForValue(value: Vehicle): Customer = {
      val revMap = customerMap map {_.swap}
      val key = revMap(value)
      key
    }

    def removeVehicle(registration:String) = {
      val allVehicles = customerMap.values
      for(vehicle <- allVehicles) {
        registration match {
          case vehicle.regNo => {
            val custName = keyForValue(vehicle).name
            customerMap.remove(keyForValue(vehicle))
            println(s"The vehicle for $custName has been removed from the garage")
          }
          case _ => "Vehicle is not in garage"
        }
      }
    }

    def registerEmployee(newEmployee:Employee) = {
      employeeList += newEmployee
      println(s"New employee ${newEmployee.name} has been added.")
    }



    def fixVehicle(registration:String) = {
      val allVehicles = customerMap.values
      var timeToFix:Double = 0
      for (vehicle <- allVehicles) {
        registration match {
          case vehicle.regNo => {
            val cust = keyForValue(vehicle).name
            println(s"The vehicle for $cust is being fixed.")
            timeToFix = vehicle.timeToFix
          }
          case _ => "Vehicle is not in garage"
        }
        timeToFix
      }
      println(s"Time to fix vehicle: $timeToFix")
    }

    def calculateBill(registration:String) = {
      var bill:Double = 0
      val allVehicles = customerMap.values
      for(vehicle <- allVehicles) {
        registration match {
          case vehicle.regNo => {
            val custName = keyForValue(vehicle).name
            bill = vehicle.timeToFix * 20
            println(f"The bill for $custName comes to £$bill%2.2f")
          }
          case _ => "Vehicle is not in garage"
        }
      }
    }

    def outputContents() = {
      println("***CONTENTS OF GARAGE***")
      for((c,v) <- customerMap) {
        println(c.toString)
        println(v.toString)
        println()
      }
    }

    def open = {
      garageIsOpen = true
    }

    def close = {
      garageIsOpen = false
    }
}
