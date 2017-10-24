class Recursion {

  //ITERATION 3 RECURSIVE
  def multiplePrintRec(message:String, number: Int): String = {
    println(message * number)
    multiplePrintRec(message, number)
  }

}
