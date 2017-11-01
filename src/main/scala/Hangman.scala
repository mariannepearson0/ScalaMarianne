import scala.io.Source

class Hangman extends Output {

  val fileName = "C:\\Users\\marianne\\IdeaProjects\\Scala_Marianne\\words_alpha.txt"
  val listOfWords = Source.fromFile(fileName).getLines().toList
  var lives = 12

  def userInput = {
    while (lives > 0) {
      val userInput = scala.io.StdIn.readLine
      //playHangman(userInput)
    }
  }

  def playHangman = {
    println("***WELCOME TO HANGMAN***")
    val selectedWordArray = listOfWords(scala.util.Random.nextInt(listOfWords.length)).toCharArray
    val guessArray = Array.fill(selectedWordArray.length)("_ ")
    val guessedLetters = scala.collection.mutable.Set[String]()
    var lives = 12
    print(guessArray.mkString)
    while(lives > 0) {
      println("Take a guess: ")
      val userInput = scala.io.StdIn.readLine
      if (guessedLetters.contains(userInput)) println("Letter already guessed")
      guessedLetters += userInput
      val guessStart = guessArray.mkString
      for (i <- 0 to selectedWordArray.length - 1) {
        if (selectedWordArray(i).toString.equals(userInput)) guessArray(i) = s"${selectedWordArray(i).toString} "
      }
      if (guessArray.mkString == guessStart) lives -= 1
      print(guessArray.mkString)
      println(s"lives: $lives")
      if (!guessArray.contains("_ ")) {
        println("You are a winner!")
        System.exit(0)
      }
    }
    println(s"You are a loser!\nThe word was ${selectedWordArray.mkString}")
  }
}
