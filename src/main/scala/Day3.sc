//FUNCTIONAL 1
java.util.TimeZone.getAvailableIDs().map(_.split('/').toList.drop(1).mkString).filter(_.length>1)

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
val alphabetArray = ('a' to 'z').toArray

def cipher(input:String) = {
  for(letter <- input.toCharArray) print(alphabetArray(alphabetArray.length - alphabetArray.indexOf(letter)-1))
}

cipher("cat")

//FUNCTIONAL 3
def gcd(int1:Int, int2:Int): Integer = if(int2 == 0) int1 else gcd(int2, int1%int2)

gcd(12,6)

//FUNCTIONAL 4
def Calcfactorial(number:Int): Integer = {
  if (number == 0) 1
  else number * Calcfactorial(number - 1)
}

Calcfactorial(3)

//FUNCTIONAL 5
def isInString(string1:String, string2:String): String = {
  if(string2.contains(string1)) s"Yes indeed, $string1 is in $string2"
  else s"No in fact, $string1 is not in $string2"
}

println(isInString("ru", "random"))

//FUNCTIONAL 6
def isInString2(func:(String,String)=>String, string1:String, string2:String) = {
  func(string1, string2)
}

println(isInString2(isInString, "ru", "random"))

//FUNCTIONAL 7
isInString2((str1:String,str2:String) => if(str2.contains(str1)) s"Yes indeed, $str1 is in $str2"
  else s"No in fact, $str1 is not in $str2",
  "ru",
  "random")

//FUNCTIONAL 8
def applyDiscounts(amount:Double): Double = {
  var total = amount
  if(amount > 100) total = total*0.9
  total = total + total*0.2
  total
}
applyDiscounts(150)

//FUNCTIONAL 9
def applyDiscountsCurried(quantity:Integer)(price:Double)(discount:Double => Double) = {
  discount(quantity*price)
}

applyDiscountsCurried(1)(150.0)(applyDiscounts)

//BLACKJACK
def blackjack(first:Int, second:Int) = {
  (first,second) match {
  case (0,0) => println("Invalid")
  case (_,_) if first>21 && second>21 => 0
  case (_,_) if (first > 21) => second
  case (_,_) if (second > 21) => first
  case (_,_) if (21 - first < 21 - second) => first
  case (_,_) if (21 - first > 21 - second)=> second
  }
}

blackjack(20,17)

//UNIQUE SUM
def uniqueSum(first:Int, second:Int, third:Int) = {
  Set(first,second,third).sum
}

uniqueSum(1,5,7)

//TOO HOT
def tooHot(temp:Int, isSummer:Boolean) = {
  if(temp>=60 && temp<=90 && isSummer == false) true
  else if(temp>=60 && temp<=100 && isSummer==true) true
  else false
}

tooHot(80,false)
tooHot(100,false)
tooHot(100,true)