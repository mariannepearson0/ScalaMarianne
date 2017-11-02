
class ChatBot_Testing extends Base {

  val chatbot = new ChatBot

  "chatbot" should "give different replies based on user input" in {
    val loops = new ChatBot with MockOutput
    loops.playChatBot("Ramona")
    loops.messages(0).mkString should equal("Yes?")
    loops.playChatBot("Where am I?")
    loops.messages(1).mkString should (equal ("I don't know, let me google that for you!") or equal ("I don't know, and I'm too lazy to look it up!"))
    loops.playChatBot("WHAT")
    loops.messages(2).mkString should equal ("Whoa, relax a bit will ya")
    loops.playChatBot("WHAT")
    loops.playChatBot("WHAT")
    loops.playChatBot("WHAT")
    loops.messages(5).mkString should equal ("I AM ANGRY TOO NOW!")
   }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }
}
