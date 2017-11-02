class BrokenKeyboard_Testing extends Base{

  val brokenKeyboard = new BrokenKeyboard

  "BrokenKeyboard" should "when given a list of keys that work on a keyboard return the longest word containing" +
    "only those letters from a provided list of words, using an input of ghi, plor and x  where x should return an" +
    "error message" in {
    val fileName = "C:\\Users\\marianne\\IdeaProjects\\Scala_Marianne\\src\\main\\scala\\brokenKeyboardInput2.txt"
    val fileNameWords = "C:\\Users\\marianne\\IdeaProjects\\Scala_Marianne\\src\\main\\scala\\WordsList.txt"
    val loops = new BrokenKeyboard with MockOutput
    loops.longestWord(fileName, fileNameWords)
    loops.messages should equal (List("high", "lollop", "There are no words you can type with this broken keyboard"))
  }

  trait MockOutput extends Output {
    var messages: Seq[String] = Seq()
    override def print(s: String) = messages = messages :+ s
  }
}
