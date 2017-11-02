class ChatBot extends Output {

  var open = true
  var angryCount = 0

  def playChatBot = {
    while (open == true) {
      val userInput = scala.io.StdIn.readLine()
      if (userInput.endsWith("?")) {
        val numb = scala.util.Random.nextInt(2)
        if (numb == 0) println("I don't know, let me google that for you!")
        else if (numb == 1) println("I don't know, and I'm too lazy to look it up!")
      }
      if (userInput == "Ramona") println("Yes?")
      if (userInput == userInput.toUpperCase) {
        if (angryCount >= 0 && angryCount <= 2) {
          println("Whoa, relax a bit will ya")
          angryCount += 1
        }
        else if (angryCount >= 3) println("I AM ANGRY TOO NOW!")
      }
      if (userInput == "exit") open = false
    }
  }
}
