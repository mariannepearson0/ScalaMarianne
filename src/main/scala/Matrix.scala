class
Matrix {

  val rand = scala.util.Random

  def printRandoms = {
    while(true){
      println()
      for (i <- 0 to rand.nextInt(500))
        print(rand.nextPrintableChar())
    }
  }

  def printRandomsRec (counter: Int = 1) : Unit = {
    if (counter > 0){
      println()
      for (i <- 0 to rand.nextInt(500))
        print(rand.nextPrintableChar())
        printRandomsRec()
    }
  }
}
