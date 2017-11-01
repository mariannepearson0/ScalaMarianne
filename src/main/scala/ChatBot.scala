class ChatBot extends Output {

  var open = true
  var angryCount = 0

  def userInput = {
    while (open == true) {
      val userInput = scala.io.StdIn.readLine
      if (userInput == "exit") open = false
      else playChatBot(userInput)
    }
  }

  def playChatBot(in: String) = {
      val userInput = in
      if (userInput.endsWith("?")) {
        val numb = scala.util.Random.nextInt(2)
        if (numb == 0) print("I don't know, let me google that for you!")
        else if (numb == 1) print("I don't know, and I'm too lazy to look it up!")
      }
      if (userInput == "Ramona") print("Yes?")
      if (userInput == userInput.toUpperCase) {
        if (angryCount >= 0 && angryCount <= 2) {
          print("Whoa, relax a bit will ya")
          angryCount += 1
        }
        else if (angryCount >= 3) print("I AM ANGRY TOO NOW!")
      }
    }
}
