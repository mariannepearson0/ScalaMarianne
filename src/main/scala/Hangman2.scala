import scala.io.Source

class Hangman2 {

  val fileName = "C:\\Users\\marianne\\IdeaProjects\\Scala_Marianne\\words_alpha.txt"
  val listOfWords = Source.fromFile(fileName).getLines().toList
  var lives = 12
  val selectedWordArray = listOfWords(scala.util.Random.nextInt(listOfWords.length)).toCharArray
  val guessArray = Array.fill(selectedWordArray.length)("_ ")
  val guessedLetters = scala.collection.mutable.Set[String]()
  println("***WELCOME TO HANGMAN***")

  def userInput = {
    while (lives >= 0) {
      if (lives == 0) println(s"You are a loser!\nThe word was ${selectedWordArray.mkString}")
      println("Take a guess: ")
      print(guessArray.mkString)
      val userInput = scala.io.StdIn.readLine
      playHangman(userInput)
    }
  }

  def playHangman(in: String) = {
    if (guessedLetters.contains(in)) println("Letter already guessed")
    guessedLetters += in
    val guessStart = guessArray.mkString
    for (i <- 0 to selectedWordArray.length - 1) {
      if (selectedWordArray(i).toString.equals(in)) guessArray(i) = s"${selectedWordArray(i).toString} "
    }
    if (guessArray.mkString == guessStart) lives -= 1
    print(guessArray.mkString)
    println(s"lives: $lives")
    if (!guessArray.contains("_ ")) {
      println("You are a winner!")
      System.exit(0)
    }
  }
}
