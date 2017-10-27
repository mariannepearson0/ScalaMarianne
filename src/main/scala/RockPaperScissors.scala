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
    if(comp.equals(userInput)) println("It's a draw!")
    if(comp.equals("rock") && userInput.equals("paper")) println("You win! Paper beats Rock")
    if(comp.equals("paper") && userInput.equals("scissors")) println("You win! Scissors beats Paper")
    if(comp.equals("scissors") && userInput.equals("rock")) println("You win! Rock beats Scissors")
    if(comp.equals("rock") && userInput.equals("scissors")) println("You lose! Rock beats Scissors")
    if(comp.equals("paper") && userInput.equals("rock")) println("You lose! Paper beats Rock")
    if(comp.equals("scissors") && userInput.equals("paper")) println("You lose! Scissors beats Paper")
  }
}
