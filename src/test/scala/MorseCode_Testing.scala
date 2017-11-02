class MorseCode_Testing extends Base {

  val morseCode = new MorseCode

  "keyForValue function" should "return the key for a given value in the morse code map" in {
    morseCode.keyForValue("....") should equal ("h")
    morseCode.keyForValue("_._.") should equal ("c")
  }

  "morseToString function" should "take a morse code string with letter separated by / and convert it " +
    "to alphanumeric string" in {
    morseCode.morseToString(".... / ._ / _") should equal ("hat")
  }

  "stringToMorse function" should "take an alphanumeric string and convert it into the morse code version" in {
    morseCode.stringToMorse("crumb") should equal ("_._. / ._. / .._ / __ / _... / ")
  }

  "the functions together" should "convert a string to morse and back again and it should return the same" in {
    val message = "hello again"
    val morse = morseCode.stringToMorse(message)
    val message_again = morseCode.morseToString(morse)
    message should equal (message_again)
  }
}
