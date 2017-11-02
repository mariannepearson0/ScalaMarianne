class Lumberjack_Testing extends Base{

  val lumberjack = new Lumberjack

  "findLowest method" should "return the lowest number from a dimensional integer array" in {
    lumberjack.findLowest() should equal (1)
    //lumberjack.findLowest(Array(Array(3, 3, 3), Array(2, 2, 3), Array(2, 4, 5))) should equal (2)
  }

  //Test is failing to start
  "placeLogs method" should "place the logs" in {
    val loops = new Lumberjack with MockOutput
    loops.placeLogs()
    println(loops.messages)
    //loops.messages should equal ("322", "223", "242")
  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }
}
