class Tetrahedral {

  def tetrahedral(n:Int):Int = {
    (n * (n+1) * (n+2)) /6
  }

  def isATetrahedral(number:Int, counter:Int=1):Any = {
    if (tetrahedral(counter) == number) s"Yes! $counter"
    else if (tetrahedral(counter) < number) isATetrahedral(number, counter+1)
    else if (tetrahedral(counter) > number) "NONE"
  }
}
