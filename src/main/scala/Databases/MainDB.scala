package Databases

import slick.jdbc.MySQLProfile.api._
import scala.concurrent.{Await, Future}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.duration.Duration
import scala.util.{Failure, Success}

object MainDB extends App {

  val db = Database.forConfig("mysqlDB")

  val peopleTable = TableQuery[People]

  val dropPeopleCmd = DBIO.seq(peopleTable.schema.drop)

  val initPeopleCmd = DBIO.seq(peopleTable.schema.create)

  def dropDB = {
    //do a drop followed by initialisePeople
    val dropFuture = Future{db.run(dropPeopleCmd)}
    //Attempt to drop the table, Await does not block here
    Await.result(dropFuture, Duration.Inf).andThen{
      case Success(_) =>  initialisePeople
      case Failure(error) => println("Dropping the table failed due to: " + error.getMessage)
        initialisePeople}
  }

  def initialisePeople = {
    //initialise people
    val setupFuture =  Future {db.run(initPeopleCmd)}
    //once our DB has finished initializing we are ready to roll, Await does not block
    Await.result(setupFuture, Duration.Inf).andThen{
      case Success(_) => runQuery
      case Failure(error) => println("Initialising the table failed due to: " + error.getMessage)}
  }

  def runQuery = {
    val insertPeople = Future {
      val query = peopleTable ++= Seq(
        (10, "Jack", "Wood", 36),
        (20, "Tim", "Brown", 24),
        (60, "Harry", "Simpson", 18),
        (40, "Ramona", "Chatbot", 73),
        (30, "Jennie", "Simpson", 42),
        (50, "Tim", "Williams", 39))
      // insert into `PEOPLE` (`PER_FNAME`,`PER_LNAME`,`PER_AGE`)  values (?,?,?)
      println(query.statements.head) // would print out the query one line up
      db.run(query)
    }
      Await.result(insertPeople, Duration.Inf).andThen {
        case Success(_) => commonSurname
        case Failure(error) => println("Welp! Something went wrong! " + error.getMessage)}
  }

  def listPeople = {
    val queryFuture = Future {
      // simple query that selects everything from People and prints them out
      db.run(peopleTable.result).map(_.foreach {
        case (id, fName, lName, age) => println(s" $id $fName $lName $age")
      })
    }
    Await.result(queryFuture, Duration.Inf).andThen {
      case Success(_) =>  db.close()  //cleanup DB connection
      case Failure(error) => println("Listing people failed due to: " + error.getMessage)}
  }

  def deletePeople = {
    val d = peopleTable.filter(_.fName === "Jack")
    val action = d.delete
    val deleteP = Future {
      db.run(action)
    }
    Await.result(deleteP, Duration.Inf).andThen {
      case Success(_) => updatePeople
      case Failure(error) => println("Uh Oh! Something went wrong! " + error.getMessage)}
  }

  def updatePeople = {
    val age = for { p <- peopleTable if p.fName === "Tim"} yield p.age
    val updateAction = age.update(30)
    val updatep = Future {
      db.run(updateAction)
    }
    Await.result(updatep, Duration.Inf).andThen {
      case Success(_) => listPeople
      case Failure(error) => println("Wuh-oh! Something went wrong! " + error.getMessage)}
  }

  def searchPeople = {
    val search = Future {
      db.run(peopleTable.filter(_.lName === "Brown").result).map(_.foreach {
        case (id, fName, lName, age) => println(s" $id $fName $lName $age")
    })
    }
    Await.result(search, Duration.Inf).andThen {
      case Success(_) =>  db.close()  //cleanup DB connection
      case Failure(error) => println("Listing people failed due to: " + error.getMessage)}
  }

  def countPeople = {
    val count = Future {
      db.run(peopleTable.length.result)
    }
    Await.result(count, Duration.Inf).andThen {
      case Success(a) => println(s"Length: $a people")
      case Failure(error) => println("Count people failed due to: " + error.getMessage)}
  }

  def averageAge = {
    val avAge = Future {
      db.run(peopleTable.map(_.age).avg.result)
      }
    Await.result(avAge, Duration.Inf).andThen {
      case Success(a) => println(s"Average age: $a")
      case Failure(error) => println("Average age failed due to: " + error.getMessage)}
  }

  def commonName = {
    val comName = Future {
      db.run(peopleTable.map(_.fName).max.result)
    }
    Await.result(comName, Duration.Inf).andThen {
      case Success(a) => println(s"Most common name: $a")
      case Failure(error) => println("Common name failed due to: " + error.getMessage)}
  }

  def commonSurname = {
    val comSur = Future {
      val nameGroups = peopleTable.groupBy(_.lName)
      db.run(peopleTable.result)
    }
    Await.result(comSur, Duration.Inf).andThen {
      case Success(a) => println(s"Most common surname: $a")
      case Failure(error) => println("Common surname failed due to: " + error.getMessage)}
  }

  dropDB

}
