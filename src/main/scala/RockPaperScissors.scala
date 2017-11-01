class RockPaperScissors {

  //println("Enter choice...")
  //val userInput = scala.io.StdIn.readLine().toLowerCase

  def computerTurn: String = {
    scala.util.Random.nextInt(3) match {
      case 0 => "rock"
      case 1 => "paper"
      case 2 => "scissors"
    }
  }

  def play(in:String, comp:String) = {
    //val comp = computerTurn
    println(s"Computer chooses $comp")
    (comp, in) match {
      case (_,_) if comp == in => "It's a draw"
      case ("rock", "paper") | ("paper", "scissors") | ("scissors", "rock") => "You win!"
      case ("rock", "scissors") | ("paper", "rock") | ("scissors", "paper") => "You lose!"
    }
  }
}
