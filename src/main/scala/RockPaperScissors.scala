class RockPaperScissors {

  println("Enter choice...")
  val userInput = scala.io.StdIn.readLine().toLowerCase
  var random = scala.util.Random

  def computerTurn: String = {
    random.nextInt(3) match {
      case 0 => "rock"
      case 1 => "paper"
      case 2 => "scissors"
    }
  }

  def play = {
    val comp = computerTurn
    println(s"Computer chooses $comp")
    (comp, userInput) match {
      case (_,_) if comp == userInput => println("It's a draw")
      case ("rock", "paper") | ("paper", "scissors") | ("scissors", "rock") => println("You win!")
      case ("rock", "scissors") | ("paper", "rock") | ("scissors", "paper") => println("You lose!")
    }
  }
}
