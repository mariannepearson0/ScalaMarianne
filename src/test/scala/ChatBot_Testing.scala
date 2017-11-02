
class ChatBot_Testing extends Base {

  val chatbot = new ChatBot

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()

    override def print(s: String) = messages = messages :+ s
  }
}
