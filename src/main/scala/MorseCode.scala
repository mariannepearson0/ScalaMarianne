class MorseCode extends Output {

  //MORSE CODE
  val morseMap = Map("a"->"._", "b"->"_...", "c"->"_._.",
    "d"->"_..", "e"->".", "f"->".._.", "g"->"__.", "h"->"....",
    "i"->"..", "j"->".___", "k"->"_._", "l"->"._..", "m"->"__",
    "n"->"_.", "o"->"___", "p"->".__.", "q"->"__._", "r"->"._.",
    "s"->"...", "t"->"_", "u"->".._", "v"->"..._", "w"->".__",
    "x"->"_.._", "y"->"_.__", "z"->"__..", " "-> " ")

  def keyForValue(value: String): String = {
    val revMap = morseMap map {_.swap}
    val key = revMap(value)
    key
  }

  def morseToString(morse:String):String = {
    var message = ""
    for (morse <- morse.split(" / ")) {
      message += keyForValue(morse)
    }
    message
  }

  def stringToMorse(message:String): String = {
    var morse = ""
    for(letter <- message.toLowerCase) {
      morse += morseMap.getOrElse(letter.toString, "") + " / "
    }
    morse
  }

}
