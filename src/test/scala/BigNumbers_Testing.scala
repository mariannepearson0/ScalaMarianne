class BigNumbers_Testing extends Base{

  val bigNumbers = new BigNumbers

  "bigNumberConverter function" should "when given a number print it out in long scale and short scale" in {
    bigNumbers.makeSomeWords(bigNumbers.bigNumberConverter("67483929917263")) should equal ("Short Scale: " +
      "67 trillion, 483 billion, 929 million, 917 thousand, 263\n" +
      "Long Scale: 67 billion, 483 milliard, 929 million, 917 thousand, 263")
  }
}
