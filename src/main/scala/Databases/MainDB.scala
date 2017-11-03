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
    val dropFuture = Future {
      db.run(dropPeopleCmd)
    }
    //Attempt to drop the table, Await does not block here
    Await.result(dropFuture, Duration.Inf).andThen {
      case Success(_) => initialisePeople
      case Failure(error) => println("Dropping the table failed due to: " + error.getMessage)
        initialisePeople
    }
  }

  def initialisePeople = {
    //initialise people
    val setupFuture = Future {
      db.run(initPeopleCmd)
    }
    //once our DB has finished initializing we are ready to roll, Await does not block
    Await.result(setupFuture, Duration.Inf).andThen {
      case Success(_) => runQuery
      case Failure(error) => println("Initialising the table failed due to: " + error.getMessage)
    }
  }

  def runQuery = {
    val insertPeople = Future {
      val query = peopleTable ++= Seq(
        (10, "Jack", "Wood", 36, "Honeycomb Lane", "London"),
        (20, "Tim", "Brown", 24, "Lovelace Avenue", "Brighton"),
        (60, "Harry", "Simpson", 18, "NutterButter Avenue", "Peterborough"),
        (40, "Ramona", "Chatbot", 73, "Honeycomb Lane", "London"),
        (70, "James", "Roberts", 60, "Honeycomb Lane", "London"),
        (80, "Maria", "Wellington", 32, "Jelly Mews", "Birmingham"),
        (30, "Jennie", "Simpson", 42, "Jelly Mews", "Birmingham"),
        (50, "Tim", "Williams", 39, "Button Crescent", "Cardiff"))
      // insert into `PEOPLE` (`PER_FNAME`,`PER_LNAME`,`PER_AGE`)  values (?,?,?)
      println(query.statements.head) // would print out the query one line up
      db.run(query)
    }
    Await.result(insertPeople, Duration.Inf).andThen {
      case Success(_) => neighbours
      case Failure(error) => println("Welp! Something went wrong! " + error.getMessage)
    }
  }

  def listPeople = {
    val queryFuture = Future {
      // simple query that selects everything from People and prints them out
      db.run(peopleTable.result).map(_.foreach {
        case (id, fName, lName, age, address, city) => println(s" $id $fName $lName $age")
      })
    }
    Await.result(queryFuture, Duration.Inf).andThen {
      case Success(_) => db.close() //cleanup DB connection
      case Failure(error) => println("Listing people failed due to: " + error.getMessage)
    }
  }

  def deletePeople = {
    val d = peopleTable.filter(_.fName === "Jack")
    val action = d.delete
    val deleteP = Future {
      db.run(action)
    }
    Await.result(deleteP, Duration.Inf).andThen {
      case Success(_) => updatePeople
      case Failure(error) => println("Uh Oh! Something went wrong! " + error.getMessage)
    }
  }

  def updatePeople = {
    val age = for {p <- peopleTable if p.fName === "Tim"} yield p.age
    val updateAction = age.update(30)
    val updatep = Future {
      db.run(updateAction)
    }
    Await.result(updatep, Duration.Inf).andThen {
      case Success(_) => listPeople
      case Failure(error) => println("Wuh-oh! Something went wrong! " + error.getMessage)
    }
  }

  def searchPeople = {
    val search = Future {
      db.run(peopleTable.filter(_.lName === "Brown").result).map(_.foreach {
        case (id, fName, lName, age, address, city) => println(s" $id $fName $lName $age")
      })
    }
    Await.result(search, Duration.Inf).andThen {
      case Success(_) => db.close() //cleanup DB connection
      case Failure(error) => println("Listing people failed due to: " + error.getMessage)
    }
  }

  def countPeople = {
    val count = Future {
      db.run(peopleTable.length.result)
    }
    Await.result(count, Duration.Inf).andThen {
      case Success(a) => println(s"Length: $a people")
      case Failure(error) => println("Count people failed due to: " + error.getMessage)
    }
  }

  def averageAge = {
    val avAge = Future {
      db.run(peopleTable.map(_.age).avg.result)
    }
    Await.result(avAge, Duration.Inf).andThen {
      case Success(a) => println(s"Average age: $a")
      case Failure(error) => println("Average age failed due to: " + error.getMessage)
    }
  }

  def commonName = {
    val comName = Future {
      db.run(peopleTable.groupBy(_.fName).map {
        case (fName, result) => (fName -> result.length)
      }.sortBy(_._2).result)
    }
    Await.result(comName, Duration.Inf).andThen {
      case Success(a) => println(s"Most common name: ${a.last._1}")
      case Failure(error) => println("Common name failed due to: " + error.getMessage)
    }
  }


  def commonSurname = {
    val comSur = Future {
      db.run(peopleTable.groupBy(_.lName).map {
        case(lName, result) => (lName -> result.length)}.sortBy(_._2).result)
    }
    Await.result(comSur, Duration.Inf).andThen {
      case Success(a) => println(s"Most common surname: ${a.last._1}")
      case Failure(error) => println("Common surname failed due to: " + error.getMessage)
    }
  }

  def commonCity = {
    val comCity = Future {
      db.run(peopleTable.groupBy(_.city).map {
        case(city, result) => (city -> result.length)}.sortBy(_._2).result)
      }
    Await.result(comCity, Duration.Inf).andThen {
      case Success(a) => println(s"Most common city: ${a.last._1}")
      case Failure(error) => println("Common city failed due to: " + error.getMessage)
    }
  }

  def neighbours = {
    val neighbours = Future {
      val most_common_street = peopleTable.groupBy(_.address).map {
        case (address, result) => (address -> result.length)}.sortBy(_._2).result
      db.run(most_common_street)

    }
    Await.result(neighbours, Duration.Inf).andThen {
      case Success(a) => val mcs = a.filter(value => value._2 > 1)
        //println(mcs)
        val next = Future {
          //val nextone = peopleTable.filter(x => mcs.contains(x.address)).result
          //val nextone = for(post <- mcs){peopleTable.filter(_.address === post._1)}.result
          val topAdd = mcs.map(_._1)
          val nextone = topAdd.foreach{if(_)}.result
          //val nextone = peopleTable.filter(_.address === mcs.last._1).result
          db.run(nextone)
        }
        Await.result(next, Duration.Inf).andThen {
          case Success(a) => println("Neighbours: " + a)
          case Failure(error) => println("Failure")
        }
      case Failure(error) => println("Common city failed due to: " + error.getMessage)
     }
  }

  dropDB
}
