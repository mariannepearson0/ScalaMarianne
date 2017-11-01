class Lumberjack extends Output {

  val size = 3
  val layout = Array(Array(1, 1, 1), Array(2, 1, 3), Array(1, 4, 1))

  def findLowest(): Int = {
    var lowest = layout(0)(0)
    for (arr <- layout) {
      for (i <- 0 to arr.length - 1) {
        if (arr(i) < lowest) lowest = arr(i)
      }
    }
    lowest
  }

  def placeLogs(logno: Int = 7): Any = {
    var logNumber = logno
    val lowest = findLowest()
      for (arr <- layout) {
        for (i <- 0 to arr.length - 1) {
          if (arr(i) == lowest) {
            arr(i) += 1
            logNumber -= 1
          }
          if (logNumber == 0) {
            for (arr <- layout) print(arr.mkString)
          }
        }
      }
      if(logNumber>0) placeLogs(logNumber)
  }
}
