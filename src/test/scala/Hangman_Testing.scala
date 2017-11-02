class Hangman_Testing extends Base {

  "playHangman function" should "simulate the game hangman" in {
    val loops = new Hangman with MockOutput
    println(loops.messages)
    loops.messages(1).split(" ") should contain only ("_")
    loops.messages(0).length should equal (loops.messages(1).split(" ").length)
  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }
}
