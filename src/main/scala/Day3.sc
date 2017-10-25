//FUNCTIONAL 1
val countryCapital = java.util.TimeZone.getAvailableIDs()

countryCapital.map(_.split('/').toList.drop(1).mkString).filter(_.length>1)

//FUNCTIONAL 2
def fibonacci(intList: List[Int]):Boolean = {
  var result:Boolean = true
  val sortList = intList.sorted
  for(i<- 0 to sortList.length -3)
  if (sortList(i) + sortList(i + 1) == sortList(i + 2)) result = true
  else result = false
  result
}

fibonacci(List(1,1,2,3,5,8))

//Is it a factorial
def factorial(n: Int): Int = {
  if (n == 0) 1
  else n * factorial(n-1)
}

def isAFactorial(number:Int, counter:Int = 1): Any= {
  if(factorial(counter) == number) s"$counter!"
  else if (factorial(counter) < number) isAFactorial(number, counter+1)
  else if (factorial(counter) > number) "NONE"
}

isAFactorial(3628800)

//CIPHER
var alphabet = "abcdefghijklmnopqrstuvwxyz"
var alphabetArray = alphabet.toCharArray

def cipher(input:String) = {
  var inputArray = input.toCharArray()
  for(letter <- inputArray){
    print(alphabetArray(alphabetArray.length - alphabetArray.indexOf(letter)-1))
  }
}

cipher("foobar")

//FUNCTIONAL 3
def gcd(int1:Int, int2:Int): Integer =
  if(int2 == 0) int1 else gcd(int2, int1%int2)

gcd(6, 12)

//FUNCTIONAL 4
def Calcfactorial(number:Int): Integer = {
  if (number == 0) 1
  else number * Calcfactorial(number - 1)
}

Calcfactorial(3)

//FUNCTIONAL 5
def isInString(string1:String, string2:String) = {
  if(string2.contains(string1)) println(s"Yes indeed, $string1 is in $string2")
  else println(s"No in fact, $string1 is not in $string2")
}

isInString("run", "random")



