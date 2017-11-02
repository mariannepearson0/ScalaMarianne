class Tetrahedral_Testing extends Base {

  val tetrahedral = new Tetrahedral

  "tetrahedral function" should "take an integer and return the tetrahedral number at that point in the series" in {
    tetrahedral.tetrahedral(5) should equal (35)
  }

  "isATetrehedral function" should "take a number and return whether it is a teetrahedral number and what the base is" in {
    tetrahedral.isATetrahedral(35) should equal ("Yes! 5")
  }

}
