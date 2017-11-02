name := "Scala_Marianne"

version := "0.1"

scalaVersion := "2.12.3"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.4"

libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.4" % "test"

libraryDependencies ++= Seq(
  "com.typesafe.slick" % "slick_2.11" % "3.2.1",
  "org.slf4j" % "slf4j-nop" % "1.7.25",
  "mysql" % "mysql-connector-java" % "6.0.6"
)
        