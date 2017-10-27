package Garage

import java.util.Calendar
import scala.util.control.Breaks._

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
            val cust = keyForValue(vehicle).name
            customerMap.remove(keyForValue(vehicle))
            println(s"The vehicle for $cust has been removed from the garage")
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
      for(vehicle <- allVehicles) {
        registration match {
          case vehicle.regNo => {
            val cust = keyForValue(vehicle).name
            println(s"The vehicle for $cust is being fixed.")
            for (employee <- employeeList) {
              if (employee.active == false) {
                employee.active = true
                employee.regWork = registration
                val startTime = Calendar.getInstance.get(Calendar.HOUR_OF_DAY)
                //if (Calendar.getInstance.get(Calendar.HOUR_OF_DAY) == startTime * vehicle.faults) {
                //vehicle.faults = 0
                println(s"The vehicle is fixed")
                employee.active = false
                employee.regWork = ""
              }
              else println("No employees are available")
              break
            }
          }
        }

          //case _ => "Vehicle is not in garage"
        }

    }

    def calculateBill(registration:String) = {
      var bill = 0
      val allVehicles = customerMap.values
      for(vehicle <- allVehicles) {
        registration match {
          case vehicle.regNo => {
            val cust = keyForValue(vehicle).name
            //bill = vehicle.faults * 20
            println(s"The bill for $cust comes to £$bill")
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
