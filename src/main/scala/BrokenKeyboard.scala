import scala.io.Source

class BrokenKeyboard extends Output {


  def longestWord(fileName:String, fileNameWords:String) = {
    val listOfLines = Source.fromFile(fileName).getLines().toList
    val arrayOfWords = Source.fromFile(fileNameWords).getLines().toArray
    for (i <- 1 to listOfLines.length - 1) {
      val wordSearch = listOfLines(i)
      val wordList = scala.collection.mutable.ListBuffer.empty[String]
      for (word <- arrayOfWords) if (word.matches(s"[$wordSearch]*")) wordList += word
      if(wordList.isEmpty) print("There are no words you can type with this broken keyboard")
      else print(wordList.maxBy(_.length))
    }
  }
}
