class Day2_testing extends Base {

  "booleanMathPattern function" should "alter equation when boolean is changed" in {
    Day2.booleanMathPattern(5,12,true) should equal (17)
    Day2.booleanMathPattern(5,12,false) should equal (60)
  }

}
