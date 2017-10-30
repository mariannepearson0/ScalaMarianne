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
            for (part <- vehicle.parts if (part.broken == true)) {
              part.partType match {
                case "tyre" => timeToFix += 0.5
                case "windscreen" => timeToFix += 0.75
                case "bumper" => timeToFix += 0.25
                case "boot" => timeToFix += 1
                case "windscreen wipers" => timeToFix += 0.4
                case "engine" => timeToFix += 3
                case "flux capacitor" => timeToFix += 10
                case _ => 0
              }
            }
          }
          case _ => "Vehicle is not in garage"
        }
        vehicle.timeToFix = timeToFix
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
            println(s"Time to fix: ${vehicle.timeToFix}")
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
//for (employee <- employeeList) {
//if (employee.active == false) {
//employee.active = true
//employee.regWork = registration
//val startTime = Calendar.getInstance.get(Calendar.HOUR_OF_DAY)
////if (Calendar.getInstance.get(Calendar.HOUR_OF_DAY) == startTime * vehicle.faults) {
////vehicle.faults = 0
//employee.active = false
//employee.regWork = ""
