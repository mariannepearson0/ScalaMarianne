//LUMBERJACK
import Garage.{Customer, Vehicle}

import scala.util.control.Breaks._
val size = 3
val layout = Array(Array(1,1,1), Array(2,1,3), Array(1,4,1))

def findLowest:Int = {
  var lowest = layout(0)(0)
  for (arr <- layout) {
    for (i <- 0 to arr.length - 1) {
      if (arr(i) < lowest) lowest = arr(i)
    }
  }
  lowest
}

def placeLogs(logno:Int = 7) = {
  var logNumber = logno
  var lowest = findLowest
    for (arr <- layout) {
      for (i <- 0 to arr.length - 1) {
        if (arr(i) == lowest) {
          arr(i) += 1
          logNumber -= 1
        }
        else if(logNumber==0) break
      }
    lowest = findLowest
  }

}

placeLogs()
for(arr <- layout) println(arr.mkString)

////TETRAHEDRAL NUMBERS
//def tetrahedral(n:Int):Int = {
//  (n * (n+1) * (n+2)) /6
//}
//
//println(tetrahedral(5))
//
//def isATetrahedral(number:Int, counter:Int=1):Any = {
//  if (tetrahedral(counter) == number) s"Yes! $counter"
//  else if (tetrahedral(counter) < number) isATetrahedral(counter+1)
//  else if (tetrahedral(counter) > number) "NONE"
//}
//
//println(isATetrahedral(35,1))

//MORSE CODE
val morseMap = Map("a"->"._", "b"->"_...", "c"->"_._.",
  "d"->"_..", "e"->".", "f"->".._.", "g"->"__.", "h"->"....",
  "i"->"..", "j"->".___", "k"->"_._", "l"->"._..", "m"->"__",
  "n"->"_.", "o"->"___", "p"->".__.", "q"->"__._", "r"->"._.",
  "s"->"...", "t"->"_", "u"->".._", "v"->"..._", "w"->".__",
  "x"->"_.._", "y"->"_.__", "z"->"__..")

def keyForValue(value: String): String = {
  val revMap = morseMap map {_.swap}
  val key = revMap(value)
  key
}

def morseToString(morse:String) = {
  for (morse <- morse.split(" / ")) {
    print(keyForValue(morse))
  }
}

def stringToMorse(message:String) = {
  for(letter <- message.toLowerCase) {
    println(morseMap.getOrElse(letter.toString, ""))
  }
}

morseToString(".__ / ___ / _. / _.. / . / ._. / .._. / .._ / ._..")
stringToMorse("princess")
