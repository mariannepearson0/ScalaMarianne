class RockPaperScissors_Testing extends Base{

  val rps = new RockPaperScissors

  "play function" should "take user and computer input and give the result of the rock paper scissors battle" in {
    rps.play("rock", "paper") should equal ("You lose!")
    rps.play("paper", "rock") should equal ("You win!")
    rps.play("rock", "rock") should equal ("It's a draw")
  }
}
