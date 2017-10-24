import scala.io.Source

class BrokenKeyboard {

  def longestWord = {

    val fileName = "C:\\Users\\marianne\\IdeaProjects\\Scala_Marianne\\src\\main\\scala\\brokenKeyboardInput.txt"
    val fileNameWords = "C:\\Users\\marianne\\IdeaProjects\\Scala_Marianne\\src\\main\\scala\\WordsList.txt"
    val listOfLines = Source.fromFile(fileName).getLines().toList
    val arrayOfWords = Source.fromFile(fileNameWords).getLines().toArray

    for (i <- 1 to listOfLines.length - 1) {
      val wordSearch = listOfLines(i)
      val wordList = scala.collection.mutable.ListBuffer.empty[String]
      for (word <- arrayOfWords) if (word.matches(s"[$wordSearch]*")) wordList += word
      println(wordList.maxBy(_.length))
    }
  }
}
