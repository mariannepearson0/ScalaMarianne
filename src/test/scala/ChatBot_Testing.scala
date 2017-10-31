import java.io.ByteArrayInputStream

import scala.io.StdIn

class ChatBot_Testing extends Base {

  val chatbot = new ChatBot

//  "chatbot" should "give different replies based on user input" in {
//    val in = new ByteArrayInputStream("Ramona".getBytes)
//    System.setIn(in)
//    //chatbot.playChatBot
//    //StdIn.readLine()
//    val loops = new ChatBot with MockOutput
//    loops.playChatBot
//    println(loops.messages)
//  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()

    override def print(s: String) = messages = messages :+ s
  }
}
