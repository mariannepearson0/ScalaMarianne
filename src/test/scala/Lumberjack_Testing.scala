class Lumberjack_Testing extends Base{

  val lumberjack = new Lumberjack

  "findLowest method" should "return the lowest number from a dimensional integer array" in {
    lumberjack.findLowest() should equal (1)
  }

  "placeLogs method" should "place the logs" in {
    val loops = new Lumberjack with MockOutput
    loops.placeLogs()
    loops.messages should equal (List("322", "223", "242"))
  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }
}
